
# Gestionale catalogo dadi
Progettazione e sviluppo di un sistema per la gestione e la vendita di dadi in un'azienda edile.

## Table of Contents
1. [Informazioni generali](#info)
2. [Prerequisiti](#requisiti)
3. [Esecuzione](#esecuzione)
4. [Autori](#autori)

### *Informazioni generali*
***
Il software si occupa della gestione e della vendita di dadi per serrare viti filettate.  
Attualmente il sistema può gestire solo dadi di tipo _esagonale alto_, ma grazie alla scalabilità del sistema, in futuro sarà possibile memorizzare e vendere anche altre tipologie di dado, tra cui: _esagonale alto_, _esagonale sottile_, _con flangia_, ecc.

Gli utenti del sistema possono essere di due tipi:
* **User** Possono vendere i dadi e consultare il catalogo, ma non hanno la possibilità di apportare modifiche ad esso.
* **Admin** Oltre ad avere i permessi dell'utente _User_, essi possono anche modificare il catalogo.  
  Le modifiche che possono essere effettuate al catalogo dadi sono le seguenti:
  * Aggiungi un nuovo set di dadi al catalogo
  * Elimina un set di dadi dal catalogo
  * Aggiorna il prezzo relativo ad un set di dadi
  * Aggiorna le scorte relative ad un set di dadi

Per consultare la documentazione completa, è possibile fare riferimento alle pagine html presenti nella directory `/doc`.

### *Prerequisiti*
***
Per utilizzare il software, occorre aver installato un'implemantazione di Java sulla propria macchina (es. OpendJDK).  
Per verificare l'installazione è possibile lanciare il seguente comando:  
```
java --version
```
**Nota** Il software è stato sviluppato nella versione Java 1.8, quindi assicurarsi di avere una versione di Java compatibile.

### *Esecuzione*
***
### Registrazione
Per accedere alle funzionalità del software è necessario registrarsi; Bisogna riempire tutti i campi in entrambe le 2 finestre con le proprie informazioni personali, riguardanti sia la persona fisica che il suo ruolo all'interno dell'azienda. Il ruolo di amministratore è importante a fini di inserimento dei nuovi dadi nel catalogo.

<img width="600" alt="119011656-90784980-b995-11eb-927c-ff6768303706" src="https://user-images.githubusercontent.com/79160832/119012062-fbc21b80-b995-11eb-88be-a6469a57338a.png">

<img width="601" alt="119011335-41caaf80-b995-11eb-9fe0-7230c42f7074" src="https://user-images.githubusercontent.com/79160832/119012279-2f04aa80-b996-11eb-83eb-bbaa7452860a.png">

### Login
Dopo essersi registrati è necessario inserire i propri dati nella schermata di login e cliccare il pulsante accedi.

<img width="600" alt="MicrosoftTeams-image" src="https://user-images.githubusercontent.com/79160832/119009822-cc121400-b993-11eb-9558-8327604fb97d.png">

### HomePage
Nella HomePage sono presenti a video tutte le informazioni dell'utente registrato sul lato sinistro, sul lato destro sono presenti tutte le operazioni che è possibile fare all'interno dell'applicazione, è presente inoltre la schermata di tutte le vendite effettuate dall'impiegato registrato. In questo momento la lista delle vendite è vuota perchè l'impiegato non ha effettuato alcuna vendita.

<img width="596" alt="MicrosoftTeams-image (2)" src="https://user-images.githubusercontent.com/79160832/119011851-bd2c6100-b995-11eb-9e33-820df0c89ec7.png">

### Vendi
La vendita del dado è possibile solo se il dado è presente nel catalogo dei dadi.
Nella sezione  vendi si può selezionare il codice del dado, inserire la vendita e il numero di pezzi, infine cliccare sul tasto vendi e terminare quindi l'operazione.

<img width="349" alt="Schermata 2021-05-20 alle 17 40 34" src="https://user-images.githubusercontent.com/79158119/119013177-0a5d0280-b997-11eb-8f8e-871c9c4d1a3c.png">


### CatalogoDadi
Nel catalogo dadi si può notare sulla sinistra la tabella relativa ad ogni dado inoltre cliccando sul tasto "visualizza" vengono mostrati dettagli maggiori su ogni singolo dado, mentre sulla destra ci sono i tasti : Aggiungi dado, Elimina dado, Aggiorna prezzo e Aggiorna scorte.

<img width="594" alt="Schermata 2021-05-20 alle 17 41 54" src="https://user-images.githubusercontent.com/79158119/119015118-e8fd1600-b998-11eb-8e14-cfded9330434.png">

### AggiungiDado
Nella sezione catalogo dadi possono aggiungere un dado al catalogo solo gli amministratori compilando i relativi campi quali: Filettatura, Materiale, Rivestimento protettivo, Luogo produzione, Data produzione e terminare l'operazione cliccando sul tatso aggiungi.

<img width="435" alt="Schermata 2021-05-20 alle 17 42 59" src="https://user-images.githubusercontent.com/79158119/119014196-02519280-b998-11eb-8b68-bdedbcfe59c8.png">

### EliminaDado
In questa sezione si deve selezionare il codice del dado e cliccare sul tasto elimina.

<img width="399" alt="Schermata 2021-05-20 alle 17 43 36" src="https://user-images.githubusercontent.com/79158119/119016475-4776c400-b99a-11eb-9db5-a1d3051ed3c9.png">

### AggiornaPrezzoDado 

In questa sezione si deve selezionare il codice del dado e inserire il prezzo del dado infine cliccare sul tasto "Aggiorna".

<img width="397" alt="Schermata 2021-05-20 alle 17 43 57" src="https://user-images.githubusercontent.com/79158119/119016718-8e64b980-b99a-11eb-911d-ab06358cd45a.png">


### AggiornaPrezzoScorte

In questa sezione si deve selezionare il codice del dado, inserire le scorte del dado e infine cliccare sul tasto "Aggiorna".

<img width="394" alt="Schermata 2021-05-20 alle 17 44 23" src="https://user-images.githubusercontent.com/79158119/119017036-df74ad80-b99a-11eb-957f-500c81827b91.png">

### *Autori*

Andrea Catacchio
Marco  De Giglio
Matteo Costantini

***
