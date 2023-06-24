<h1>Springboot API</h1><br>
<h2>Warunek zaliczenia</h2><br>
Warunkiem zaliczenia jest przygotowanie aplikacji serwerowej opartej o REST API oraz raportu komunikacji z tym serwerem według podanego scenariusza.
Raport komunikacji z serwerem powinien zawierać zestawienie wywołanych żądań do serwera wraz z adresem zasobu, metodą http, body żądania, nagłówkami żądania oraz odpowiedzią serwera na wysłane żądanie w postaci kodu odpowiedzi http oraz body odpowiedzi.

Przykładowy opis żądania z ćwiczeń:
Metoda: POST
Adres zasobu: http://localhost:8080/api/activities
Nagłówki: Content-Type: application/json
Request Body:
{
"nazwa": "programowanie",
"priorytet": 10
}
Odpowiedź:
HTTP Code: 200 OK
Body: brak

W ramach projektu należy przygotować REST API bazujące na zasobie przedmiotów na studia. Każdy przedmiot na studia powinien zawierać informacje o:
- nazwie przedmiotu,
- punktach ects,
- numerze sali, w której odbywają się zajęcia,
- informacji czy przedmiot kończy się egzaminem.

Serwer powinien umożliwiać wprowadzanie nowych przedmiotów, pobieranie przedmiotów oraz usuwanie przedmiotów.
Ocena za zaliczenie będzie uzależniona od złożoności przygotowanego rozwiązania.
W podstawowej wersji serwer powinien umożliwiać wprowadzanie nowego przedmiotu, pobieranie wszystkich przedmiotów i usuwanie wszystkich przedmiotów. W rozszerzonej wersji serwer powinien pozwalać na filtrację pod kątem informacji o tym czy przedmiot kończy się egzaminem oraz o filtrację po numerze sali, w której obywają się zajęcia. Serwer powinien także udostępniać możliwość pobierania konkretnego zasobu w oparciu o identyfikator oraz usuwanie konkretnego przedmiotu w oparciu o identyfikator.

Scenariusz do raportu:
1. Wprowadzenie przedmiotów do systemu w podanej kolejności:
- Nazwa: Metodologie obiektowe, ECTS: 2, Sala: 216, Egzamin: tak,
- Nazwa: Testowanie oprogramowania, ECTS: 1, Sala: 216, Egzamin: nie,
- Nazwa: Technologie i aplikacje webowe, ECTS: 3, Sala: 208, Egzamin: nie,
- Nazwa: Zarządzanie projektem informatycznym, ECTS: 2, Sala: 216, Egzamin: nie,
- Nazwa: Zaawansowane technologie bazodanowe, ECTS: 3, Sala: 208, Egzamin: nie,
- Nazwa: Technologie komponentowe i sieciowe, ECTS: 2, Sala: 208, Egzamin: tak
2. Pobranie wszystkich przedmiotów,
3. Pobranie przedmiotów, które mają egzamin,
4. Pobranie przedmiotów, które odbywają się w sali 216,
5. Pobranie przedmiotów które nie mają egzaminu i odbywają się w sali 208,
6. Pobranie przedmiotu o identyfikatorze 3,
7. Pobranie przedmiotu o identyfikatorze 15,
8. Usunięcie przedmiotu o identyfikatorze 2,
9. Pobranie wszystkich przedmiotów,
10. Usunięcie wszystkich przedmiotów,
11. Pobranie wszystkich przedmiotów.

<h2>Przeprowadzenie scenariusza</h2><br>
<h3>1. Wprowadzenie przedmiotów do systemu</h3><br>

Wproadzenie przedmiotu Metodologie obiektowe, ECTS: 2, Sala: 216, Egzamin: tak,
```html
POST localhost:8080/API/classes
```
```JSON
{
    "name": "Metodologie obiektowe",
    "ECTS": 2,
    "room_no": 216,
    "exam": true
}
```
Odpowiedź:

```html
200 OK
Body: brak
```

Pozostałe przedmioty:

```JSON
{
    "name": "Testowanie oprogramowania",
    "ECTS": 1,
    "room_no": 216,
    "exam": false
},
{
    "name": "Technologie i aplikacje webowe",
    "ECTS": 3,
    "room_no": 208,
    "exam": false
},
{
    "name": "Zarządzanie projektem informatycznym",
    "ECTS": 2,
    "room_no": 216,
    "exam": false
},
{
    "name": "Zaawansowane technologie bazodanowe",
    "ECTS": 3,
    "room_no": 208,
    "exam": false
},
{
    "name": "Technologie komponentowe i sieciowe",
    "ECTS": 2,
    "room_no": 208,
    "exam": true
}
```

Odpowiedź:

```html
200 OK
Body: brak
```

<h3>2. Pobranie wszystkich przedmiotów</h3><br>

```html
GET localhost:8080/API/classes
```

Odpowiedź:

```html
200 OK
Body: 
```
```JSON
[
    {
        "id": 1,
        "name": "Metodologie obiektowe",
        "ECTS": 2,
        "room_no": 216,
        "exam": true
    },
    {
        "id": 2,
        "name": "Testowanie oprogramowania",
        "ECTS": 1,
        "room_no": 216,
        "exam": false
    },
    {
        "id": 3,
        "name": "Technologie i aplikacje webowe",
        "ECTS": 3,
        "room_no": 208,
        "exam": false
    },
    {
        "id": 4,
        "name": "Zarządzanie projektem informatycznym",
        "ECTS": 2,
        "room_no": 216,
        "exam": false
    },
    {
        "id": 5,
        "name": "Zaawansowane technologie bazodanowe",
        "ECTS": 3,
        "room_no": 208,
        "exam": false
    },
    {
        "id": 6,
        "name": "Technologie komponentowe i sieciowe",
        "ECTS": 2,
        "room_no": 208,
        "exam": true
    }
]
```

<h3>3. Pobranie przedmiotów, które mają egzamin</h3><br>

```html
GET localhost:8080/API/classes?exam=true
```

Odpowiedź:

```html
200 OK
Body:
```
```JSON
[
    {
        "id": 1,
        "name": "Metodologie obiektowe",
        "ECTS": 2,
        "room_no": 216,
        "exam": true
    },
    {
        "id": 6,
        "name": "Technologie komponentowe i sieciowe",
        "ECTS": 2,
        "room_no": 208,
        "exam": true
    }
]
```
<h3>4. Pobranie przedmiotów, które odbywają się w sali 216</h3><br>

```html
GET localhost:8080/API/classes?room_no=216
```

Odpowiedź:

```html
200 OK
Body:
```
```JSON
[
    {
        "id": 1,
        "name": "Metodologie obiektowe",
        "ECTS": 2,
        "room_no": 216,
        "exam": true
    },
    {
        "id": 2,
        "name": "Testowanie oprogramowania",
        "ECTS": 1,
        "room_no": 216,
        "exam": false
    },
    {
        "id": 4,
        "name": "Zarządzanie projektem informatycznym",
        "ECTS": 2,
        "room_no": 216,
        "exam": false
    }
]
```
<h3>5. Pobranie przedmiotów które nie mają egzaminu i odbywają się w sali 208</h3><br>

```html
GET localhost:8080/API/classes?exam=false&room_no=208
```

Odpowiedź:

```html
200 OK
Body:
```
```JSON
[
    {
        "id": 3,
        "name": "Technologie i aplikacje webowe",
        "ECTS": 3,
        "room_no": 208,
        "exam": false
    },
    {
        "id": 5,
        "name": "Zaawansowane technologie bazodanowe",
        "ECTS": 3,
        "room_no": 208,
        "exam": false
    }
]
```
<h3>6. Pobranie przedmiotu o identyfikatorze 3</h3><br>

```html
GET localhost:8080/API/classes/3
```

Odpowiedź:

```html
200 OK
Body:
```
```JSON
{
    "id": 3,
    "name": "Technologie i aplikacje webowe",
    "ECTS": 3,
    "room_no": 208,
    "exam": false
}
```

<h3>7. Pobranie przedmiotu o identyfikatorze 15</h3><br>

```html
GET localhost:8080/API/classes/15
```

Odpowiedź:

```html
404 Not Found
Body: brak
```

<h3>8. Usunięcie przedmiotu o identyfikatorze 2</h3><br>

```html
DELETE localhost:8080/API/classes/2
```

Odpowiedź:

```html
200 OK
Body: brak
```

<h3>9. Pobranie wszystkich przedmiotów</h3><br>

```html
GET localhost:8080/API/classes
```

Odpowiedź:

```html
200 OK
Body:
```
```JSON
[
    {
        "id": 1,
        "name": "Metodologie obiektowe",
        "ECTS": 2,
        "room_no": 216,
        "exam": true
    },
    {
        "id": 3,
        "name": "Technologie i aplikacje webowe",
        "ECTS": 3,
        "room_no": 208,
        "exam": false
    },
    {
        "id": 4,
        "name": "Zarządzanie projektem informatycznym",
        "ECTS": 2,
        "room_no": 216,
        "exam": false
    },
    {
        "id": 5,
        "name": "Zaawansowane technologie bazodanowe",
        "ECTS": 3,
        "room_no": 208,
        "exam": false
    },
    {
        "id": 6,
        "name": "Technologie komponentowe i sieciowe",
        "ECTS": 2,
        "room_no": 208,
        "exam": true
    }
]
```

<h3>10. Usunięcie wszystkich przedmiotów</h3><br>

```html
DELETE localhost:8080/API/classes
```

Odpowiedź:

```html
200 OK
Body: brak
```

<h3>11. Pobranie wszystkich przedmiotów</h3><br>

```html
GET localhost:8080/API/classes
```

Odpowiedź:

```html
200 OK
Body: brak
```
