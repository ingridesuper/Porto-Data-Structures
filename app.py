import warnings
warnings.filterwarnings('ignore', category=FutureWarning) # se ignoră toate avertismentele de tip FutureWarning.
from flask import abort, render_template, Flask #importă funcțiile și clasele necesare din modulul Flask pentru a crea aplicația web. 
#abort este utilizat pentru a returna erori HTTP, render_template pentru a returna pagini HTML și Flask pentru a crea o 
#instanță a aplicației Flask.
import logging
import db #baza de date

APP = Flask(__name__) #se creează o instanță a aplicației Flask, care va fi utilizată pentru a defini rutele și a trata cererile HTTP.
#Sunt definite mai multe rute pentru diferite pagini și funcționalități ale aplicației, cum ar fi listarea filmelor, căutarea de filme, afișarea detaliilor despre filme, listarea actorilor și multe altele. Fiecare rută primește cererea HTTP corespunzătoare și returnează un răspuns HTML generat din șabloane folosind render_template.

#În unele cazuri, se utilizează și funcții precum abort pentru a returna coduri de eroare HTTP, cum ar fi 404 Not Found.

# Start page
@APP.route('/')
def index():
    stats = {} #stats dictionary
    stats = db.execute('''
SELECT * FROM
      (SELECT 'Lactate' , COUNT(*) n_lactate FROM produse where tip=1)
  JOIN
      (SELECT 'Patiserie', COUNT(*) n_patiserie FROM produse where tip=2)

  JOIN
      (SELECT 'Congelate', COUNT(*) n_congelate FROM produse where tip=4)
  JOIN
      (SELECT 'Sosuri', COUNT(*) n_sosuri FROM produse where tip=5)
  JOIN
      (SELECT 'Chimice', COUNT(*) n_chimice FROM produse where tip=6)
  JOIN
      (SELECT 'Basics', COUNT(*) n_basics FROM produse where tip=7)
  JOIN
      (SELECT 'Compot', COUNT(*) n_compot FROM produse where tip=8)
  JOIN
      (SELECT 'Nuci si seminte', COUNT(*) n_nuciseminte FROM produse where tip=9)
  JOIN
      (SELECT 'Legume, fructe', COUNT(*) n_legumefructe FROM produse where tip=10)
  JOIN
      (SELECT 'Condimente', COUNT(*) n_condimente FROM produse where tip=11)
  JOIN
      (SELECT 'Carne si peste' , COUNT(*) n_carnepeste FROM produse where tip=12)
  JOIN
      (SELECT 'Ulei si otet', COUNT(*) n_uleiotet FROM produse where tip=13)
  JOIN
      (SELECT 'Paste', COUNT(*) n_paste FROM produse where tip=14)
  JOIN
      (SELECT 'Obiecte bucatarie', COUNT(*) n_obiecte FROM produse where tip=15)
  JOIN
      (SELECT 'Panificatie', COUNT(*) n_panificatie FROM produse where tip=16)
  JOIN
      (SELECT 'Concentrate', COUNT(*) n_concentrate FROM produse where tip=17)
  JOIN
      (SELECT 'Creme', COUNT(*) n_creme FROM produse where tip=18)
  JOIN
      (SELECT 'Dulceata si gem', COUNT(*) n_dulceatagem FROM produse where tip=19)
  JOIN
      (SELECT 'Miere', COUNT(*) n_miere FROM produse where tip=20)
  JOIN
      (SELECT 'Pasta', COUNT(*) n_pasta FROM produse where tip=21)
  JOIN
      (SELECT 'Umplutura', COUNT(*) n_umplutura FROM produse where tip=22)
    ''').fetchone() #primul rand obv
    logging.info(stats)
    return render_template('index.html',stats=stats) #flask, dinamic pune in index.html acest dict

# Produse
@APP.route('/produse/')
def list_produse():
    try:
        produse = db.execute(
            '''
            SELECT p.id as id, p.denumire as denumire, p.unitate as unitate, f.tara as tara, t.nume as tip
            FROM furnizori f
            JOIN produse p ON f.id = p.furnizor
            JOIN tipprodus t ON p.tip = t.id
            ORDER BY id
            '''
        ).fetchall()
        return render_template('produse-list.html', produse=produse)
    except Exception as e:
        print(f"An error occurred: {e}")
        return "Internal Server Error", 500

@APP.route('/produse/<int:id>/')
def get_produs(id):
  produs = db.execute(
      '''
      SELECT p.id as id, p.denumire as denumire, p.unitate as unitate, f.tara as tara, t.nume as tip
            FROM furnizori f
            JOIN produse p ON f.id = p.furnizor
            JOIN tipprodus t ON p.tip = t.id
      WHERE p.id = ?
      ''', [id]).fetchone()
  if produs is None:
     abort(404, 'Produsul cu id {} nu exista.'.format(id))
  return render_template('produse-id.html', 
           produs=produs)


@APP.route('/produse/searchbydenumire/<expr>/')
def search_produs(expr):
  search = { 'expr': expr }
  expr = '%' + expr + '%'
  produse = db.execute(
      ''' 
      SELECT p.id as id, p.denumire as denumire, p.unitate as unitate, f.tara as tara, t.nume as tip
            FROM furnizori f
            JOIN produse p ON f.id = p.furnizor
            JOIN tipprodus t ON p.tip = t.id
            where denumire like ?
      ''', [expr]).fetchall()
  return render_template('produse-search-denumire.html',
           search=search,produse=produse)


@APP.route('/produse/searchbycountry/<expr>/')
def search_produs_by_country(expr):
  search = { 'expr': expr }
  produse = db.execute(
      ''' 
      SELECT p.id as id, p.denumire as denumire, p.unitate as unitate, f.tara as tara, t.nume as tip
            FROM furnizori f
            JOIN produse p ON f.id = p.furnizor
            JOIN tipprodus t ON p.tip = t.id
            where tara like ?
      ''', [expr]).fetchall()
  return render_template('produse-search-by-country.html',
           search=search,produse=produse)

@APP.route('/produse/searchbycategorie/<expr>/')
def search_produs_by_categorie(expr):
  search = { 'expr': expr }
  expr = '%' + expr + '%'
  produse = db.execute(
      ''' 
      SELECT p.id as id, p.denumire as denumire, p.unitate as unitate, f.tara as tara, t.nume as tip
            FROM furnizori f
            JOIN produse p ON f.id = p.furnizor
            JOIN tipprodus t ON p.tip = t.id
            where t.nume like ?
      ''', [expr]).fetchall()
  return render_template('produse-search-by-categorie.html',
           search=search,produse=produse)

# # Actors
# @APP.route('/actors/')
# def list_actors():
#     actors = db.execute('''
#       SELECT ActorId, Name 
#       FROM Actor
#       ORDER BY Name
#     ''').fetchall()
#     return render_template('actor-list.html', actors=actors)


# @APP.route('/actors/<int:id>/')
# def view_movies_by_actor(id):
#   actor = db.execute(
#     '''
#     SELECT ActorId, Name
#     FROM ACTOR 
#     WHERE ActorId = ?
#     ''', [id]).fetchone()

#   if actor is None:
#      abort(404, 'Actor id {} does not exist.'.format(id))

#   movies = db.execute(
#     '''
#     SELECT MovieId, Title
#     FROM MOVIE NATURAL JOIN MOVIE_ACTOR
#     WHERE ActorId = ?
#     ORDER BY Title
#     ''', [id]).fetchall()

#   return render_template('actor.html', 
#            actor=actor, movies=movies)
 
# @APP.route('/actors/search/<expr>/')
# def search_actor(expr):
#   search = { 'expr': expr }
#   # SQL INJECTION POSSIBLE! - avoid this!
#   actors = db.execute(
#       ' SELECT ActorId, Name'
#       ' FROM ACTOR '
#       ' WHERE Name LIKE \'%' + expr + '%\''
#     ).fetchall()

#   return render_template('actor-search.html', 
#            search=search,actors=actors)

# # Genres
# @APP.route('/genres/')
# def list_genres():
#     genres = db.execute('''
#       SELECT GenreId, Label 
#       FROM GENRE
#       ORDER BY Label
#     ''').fetchall()
#     return render_template('genre-list.html', genres=genres)

# @APP.route('/genres/<int:id>/')
# def view_movies_by_genre(id):
#   genre = db.execute(
#     '''
#     SELECT GenreId, Label
#     FROM GENRE 
#     WHERE GenreId = ?
#     ''', [id]).fetchone()

#   if genre is None:
#      abort(404, 'Genre id {} does not exist.'.format(id))

#   movies = db.execute(
#     '''
#     SELECT MovieId, Title
#     FROM MOVIE NATURAL JOIN MOVIE_GENRE
#     WHERE GenreId = ?
#     ORDER BY Title
#     ''', [id]).fetchall()

#   return render_template('genre.html', 
#            genre=genre, movies=movies)

# # Streams
# @APP.route('/streams/<int:id>/')
# def get_stream(id):
#   stream = db.execute(
#       '''
#       SELECT StreamId, StreamDate, Charge, MovieId, Title, CustomerId, Name
#       FROM STREAM NATURAL JOIN MOVIE NATURAL JOIN CUSTOMER 
#       WHERE StreamId = ?
#       ''', [id]).fetchone()

#   if stream is None:
#      abort(404, 'Stream id {} does not exist.'.format(id))

#   return render_template('stream.html', stream=stream)


# # Staff
# @APP.route('/staff/')
# def list_staff():
#     staff = db.execute('''
#       SELECT S1.StaffId AS StaffId, 
#              S1.Name AS Name,
#              S1.Job AS Job, 
#              S1.Supervisor AS Supervisor,
#              S2.Name AS SupervisorName
#       FROM STAFF S1 LEFT JOIN STAFF S2 ON(S1.Supervisor = S2.StaffId)
#       ORDER BY S1.Name
#     ''').fetchall()
#     return render_template('staff-list.html', staff=staff)

# @APP.route('/staff/<int:id>/')
# def show_staff(id):
#   staff = db.execute(
#     '''
#     SELECT StaffId, Name, Supervisor, Job
#     FROM STAFF
#     WHERE staffId = ?
#     ''', [id]).fetchone()

#   if staff is None:
#      abort(404, 'Staff id {} does not exist.'.format(id))
#   superv={}
#   if not (staff['Supervisor'] is None):
#     superv = db.execute(
#       '''
#       SELECT Name
#       FROM staff
#       WHERE staffId = ?
#       ''', [staff['Supervisor']]).fetchone()
#   supervisees = []
#   supervisees = db.execute(
#     '''
#       SELECT StaffId, Name from staff
#       where Supervisor = ?
#       ORDER BY Name
#     ''',[id]).fetchall()

#   return render_template('staff.html', 
#            staff=staff, superv=superv, supervisees=supervisees)
