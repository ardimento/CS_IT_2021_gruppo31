
# Gestionale catalogo dadi
Sistema per la gestione di un catalogo di dadi all'interno di un'azienda edile.
Il sistema permette di registrare le vendite relative ai ai dadi presenti nel catalogo. Inoltre è possibile memorizzare tutte le informazioni riguardanti un dado, nel rispetto della norma EN ISO 898-2. 
***
## Indice contenuti
1. [Informazioni generali](#info)
2. [Prerequisiti](#requisiti)
3. [Guida all'uso](#esecuzione)
4. [Autori](#autori)
***
## *Informazioni generali*
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
***
## *Prerequisiti*
Per utilizzare il software, occorre aver installato un'implementazione di Java sulla propria macchina (es. OpenJDK).  
Per verificare l'installazione è possibile lanciare il seguente comando:  
```
java --version
```
**Nota** Il software è stato sviluppato nella versione Java 1.8, quindi assicurarsi di avere una versione di Java compatibile.
***
## *Guida*
### Registrazione
Per accedere al sistema è necessario registrarsi. Nella schermata di Login, in basso è presente il pulsante per la registrazione.

![registrazione1](https://user-images.githubusercontent.com/55923261/120051170-df6e5080-c01f-11eb-8269-f0fbd65f76ce.png)

Occorre quindi fornire al sistema tutti i dati richiesti, compilando i campi con le proprie informazioni personali. Nell'ultima schermata è inoltre possibile specificare se l'utente vuole registrarsi come amministratore. Per consultare i parametri di inserimento, cliccare sul pulsando di `Info`.

![registrazione2](https://user-images.githubusercontent.com/55923261/120051201-00cf3c80-c020-11eb-9b76-4a50dfa2ff7a.png)

![registrazione3](https://user-images.githubusercontent.com/55923261/120051205-0593f080-c020-11eb-97fc-705382839c4e.png)


### Login
Dopo la registrazione, è possibile accedere al sistema inserendo username e password.

![login](https://user-images.githubusercontent.com/55923261/120051417-daf66780-c020-11eb-8dbd-70ef52572117.png)

### HomePage
Nella Homepage sono riportate tutte le informazioni dell'utente fornite in fase di registrazione. Inoltre è presente la tabella delle vendite effettuate dall'utente. Ogni utente può vedere solo le sue vendite, a differenza del catalogo dei dadi che invece è unico e condiviso tra tutti gli utenti del sistema.

![home](https://user-images.githubusercontent.com/55923261/120051563-6d970680-c021-11eb-86b5-edb158fd7c53.png)

Nella Homepage è possibile effettuare una vendita cliccando sul pulsante `Vendi` oppure è possibile consultare il catalogo dei dadi cliccando sul pulsante `Catalogo dadi`. Inoltre è possibile consultare le vendite annue e giornaliere rimanenti cliccando sul pulsante `?`. Per effettuare il Logout cliccare sul pulsante `Esci`.

### Vendita
Attraverso la seguente schermata è possibile effettuare una vendita. Nel form è possibile indicare il codice del dado da vendere, la data di vendita e la quantità di pezzi venduti. Cliccando sul pulsante `Vendi` e tutti i parametri sono rispettati, avviene a vendita. Cliccando sul pulsante `Visualizza` è possibile consulate tutti i dettagli sul dado venduto. Per consultare i parametri di inserimento, cliccare sul pulsando di `Info`.

![vendita](https://user-images.githubusercontent.com/55923261/120051852-b602f400-c022-11eb-9d6d-1dd01efe7829.png)

### Catalogo
Nel catalogo dadi è presente la tabella con tutti i dadi presenti in magazzino. Il catalogo è unico ed è condiviso con tutti gli utenti del sistema. Le scorte dei singoli dadi vengono aggiornate ad ogni vendita. Nella seguente schermata sono presenti 4 pulsanti, relativi alle funzionalità aggiuntive per gli utenti amministratori: il catalogo per gli utenti non amministratori, invece, non contiene i 4 pulsanti, ma solo la tabella con i dadi disponibili. Cliccando sul pulsante `Visualizza` è possibile consulate tutti i dettagli sul dado.

![catalogo](https://user-images.githubusercontent.com/55923261/120051871-c915c400-c022-11eb-87ee-db77baf6310b.png)

*Nota:* Nel catalogo vengono indicate le tipologie di dado disponibili (individuate da un codice univoco), per ognuna delle quali poi viene indicato il numero di pezzi. Quindi nella schermata precedente non sono presenti 3 dadi, ma piuttosto 3 tipi di dado.

L'utente amministratore può quindi modificare il catalogo dadi aggiungendo o rimuovendo un tipo di dado dal catalogo, oppure aggiornando le quantità o il prezzo di un tipo di dado presente nel catalogo. La schemata seguente consente di aggiungere un tipo di dado al catalogo. Per consultare i parametri di inserimento, cliccare sul pulsando di `Info`.

![aggiungi](https://user-images.githubusercontent.com/55923261/120052239-8c4acc80-c024-11eb-9c95-d98c5713721a.png)

Gli altri pulsanti all'interno del catalogo operano in maniera simile, quindi si indica il codice del dado tra quelli presenti per eliminarlo dal catalogo, oppure viene indicato anche il nuovo prezzo o il nuovo numero di pezzi per aggiornare un dado nel catalogo.

### *Autori*

Matteo Costantini
Andrea Catacchio 
Marco De Giglio

***
