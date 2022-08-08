# eCibCoiN
Lucrare de Licenta

Este o aplicatie mobila dezvoltata in Android Studio. 

![image](https://user-images.githubusercontent.com/75160001/183471054-770bda5b-da32-453a-8096-4c8285a62522.png)

De aici putem naviga 
mai departe către zona de creare cont în cazul în care nu avem un cont deja creat sau către 
zona de accesare a contului. Ca și elemente de grafică am optat pentru 3 tipuri de elemente: 
text simplu, butoane accesibile și zona de fundal atractivă. În zona de fundal avem planeta 
Pământ văzută din spațiu și numele aplicație, eCibCoin, încadrat de un meniu holografic 
prezent in filmele science fiction. Codul dezvoltat în fișierul xml (Extensible Markup 
Language) prezintă un textview pentru afișarea unui text și două butoane folosite pentru 
navigarea mai departe către opțiunea aleasă.

![image](https://user-images.githubusercontent.com/75160001/183471526-cf3f7148-b631-496a-abc0-5622cc68c155.png)

Aici avem cele doua ferestre, de creare cont prezentată într-un emulator în partea dreapta si logare în cont prezentată în Android Studio. Ambele implementări dispun măsuri de gestionare a erorilor în completarea datelor, astfel: 
-	utilizatorul trebuie să introducă o adresa de email valida atât la crearea contului cât și  la logare și prin validitate mă refer la terminația specifică adreselor de email (@gmail.com, @yahoo.com si altele). Lipsa introducerii unui email corect scris va arunca o eroare ce va afișa un mesaj așa cum este prezentat mai sus.
-	parola introdusă atât la crearea contului cât și la accesarea lui trebuie să îndeplinească un set de cerințe altfel va arunca o eroare și va afișa un mesaj. Zona nu trebuie lăsată necompletată iar minimul de caractere pentru a nu afișa eroarea este de minim 6. 

![image](https://user-images.githubusercontent.com/75160001/183471711-3624807c-d9be-4b0e-b983-97ab2a6014e9.png)

Acesta este meniul principal al aplicației eCibCoin ce apare în urma creări unui cont nou sau a introducerii în pagina de logare a credențialelor corecte pentru acces.

![image](https://user-images.githubusercontent.com/75160001/183471901-ece7881c-444c-4e6b-976f-3d99e9340587.png)![image](https://user-images.githubusercontent.com/75160001/183471923-4cafba06-83bc-4964-b844-51e0faa34e37.png)

Conectarea aplicației cu platforma CoinMarketCap a fost printre cele mai dificile implementări în cadrul aplicației. Ca și pași pentru realizarea conectării au fost: 
•	Am creat o activitate goală în cadrul aplicației denumita Criptomonede cu cele două fișiere incluse: Criptomonede.java și activity_criptomonede.xml
•	Pentru stocarea datelor (nume, simbol și preț) a fost nevoie de o clasă model pentru facilitarea acestui lucru;
•	Următorul pas a fost crearea unui fișier Layout pentru a afișa simbolul, numele criptomonedei și valoarea;
•	Pentru a seta datele fiecărui item afișate în fișierul Layout prezentat mai sus, am folosit o clasă java adaptoare; 
•	Am creat un cont de dezvoltator pe CoinMarketCap pentru a avea acces la codul API necesar interconectării;
•	Ca și ultim pas am dezvoltat un cod în Criptomonede.java ce a inclus toate fișierele prezentate anterior la care am adăugat un filtru ce afișează doar anumite criptomonede în funcție de datele introduse;


![image](https://user-images.githubusercontent.com/75160001/183473187-92e18a62-04ac-47e1-878f-d3a4f29b6121.png)![image](https://user-images.githubusercontent.com/75160001/183473209-416de2f8-86f4-4588-8a38-e131d227bb2f.png)

Zona știrilor are la bază interconectarea aplicației eCibCoin la platforma NewsAPI printr-un API oferit la crearea unui cont. Aplicația își asuma rolul de a oferi utilizatorului acces la toate știrile ce includ criptomonede, de la legi până la dezvoltare de noi tehnologii bazate pe ideea de blockchain. Mai sus avem două imagini ale ecranului. Prima ne arată știrile cele mai importante la ora actuală sub forma unei liste și are în componență următoarele informații: numele articolului, autorul, data la care a fost publicat articolul și partea de introducere a articolului respectiv. A doua imagine apare atunci când utilizatorul dorește să citească o informație și apasă pe una din știri, în cazul meu am accesat prima știre din lista. După cum putem observa, aplicația rulează cu succes oferind utilizatorului acces la o gamă largă de informații.

![image](https://user-images.githubusercontent.com/75160001/183473410-5c56ffaa-b4ae-4871-89c9-9efd2c68e08a.png)

Zona de social media joacă un rol importat în educarea utilizatorului în ceea ce privește zona de blockchain și criptomonede și are ca scop conectarea acestuia cu mediul respectiv. Pentru atingerea acestui obiectiv am dezvoltat o legătură cu cele mai importante aplicații la ora actuală: Facebook, Youtube și Instagram.

![image](https://user-images.githubusercontent.com/75160001/183473492-f4747890-e2f2-44b9-b2cc-971bf2ccb383.png)![image](https://user-images.githubusercontent.com/75160001/183473503-7d0c8f07-a676-409c-a673-420fbe4fd6b7.png)

O aplicație nu poate avea succes fără o zonă în care utilizatorul să-și poată scrie impresiile, de aceea am dorit ca acest lucru să fie dezvoltat și în aplicația eCibCoin. Zona de feedback este mai mult pentru noi dezvoltatorii pentru că utilizatorul întotdeauna va vedea dincolo de ce putem dezvolta noi și poate veni cu idei mai bune în ceea ce privește aplicația. În urma mesajelor din partea utilizatorilor, dezvoltatorii pot veni cu optimizare pe parte de memorie, grafică dar și noi utilități. Mai sus avem prezentată o conexiune a aplicației cu Firebase, locul unde am ales să stochez toate mesajele primite de la utilizatorii înregistrați. 

![image](https://user-images.githubusercontent.com/75160001/183473567-d81273dd-1b2f-4f9b-9ec2-3656092c6b42.png)

Aceasta e zona unde utilizatorul își poate salva anumite idei ce îi survin în timp ce utilizează aplicația. Se poate memora doar o singură notă cu posibilitatea de a vedea momentul când nota a fost actualizată. 

![image](https://user-images.githubusercontent.com/75160001/183473650-21b47cc6-bcf5-4a5c-bd9d-43d70d562492.png)

Zona evenimentelor vine în ajutorul utilizatorului și are ca scop salvarea în memoria telefonului a unor evenimente la care dorește să participe pe viitor. Acest lucru a fost implementat folosind librăria SQliteDatabase din Android Studio. Se pot adăuga evenimente, baza de date fiind afișată sub forma unei liste unde utilizatorul poate alege una din cele două variante, să actualizeze evenimentul sau să-l șteargă. Odată șters evenimentul acesta nu poate fi recuperat, ștergerea fiind definitivă.



