
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
Per acedere alle funzionalità del software è necessario registrarsi; Bisogna riempire tutti i campi in entrabe le 2 finestre con le proprie informazioni personali riguardanti sia la persona fisica che il suo ruolo all'interno dell'azienda. Il ruolo di amministratore è importante a fini di inserimento dei nuovi dadi nel catalogo.
<img width="600" alt="MicrosoftTeams-image" src="https://user-images.githubusercontent.com/79160832/119009822-cc121400-b993-11eb-9558-8327604fb97d.png">![Uploading MicrosoftTeams-image (1).png…]()


### Login
Dopo essersi registrati è necessario inserire i propri dati nella schermata di login e cliccare il pulsante accedi.
<img width="600" alt="MicrosoftTeams-image" src="https://user-images.githubusercontent.com/79160832/119009822-cc121400-b993-11eb-9558-8327604fb97d.png">
### *Autori*
***
