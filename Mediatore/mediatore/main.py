import unirest
import os
from time import sleep

if __name__ == "__main__":
    print("Benvenuto mediatore legale, inserisci il tuo codice:")
    codiceMediatore = raw_input()
    print("tento la connessione con il codice: " + codiceMediatore)
    # effettuo una richiesta post con la chiave del mediatore (mi restituira' la lista dei servizi)
    response = unirest.post(
        "http://localhost:8080/Site/MediatoreHandler",
        params={
            "op" : "mediatore",
            "key" : codiceMediatore
        }
    )

    # se la chiave e' corretta o non ci sono stati errori
    if(response.body!="error"):
        os.system("cls")
        print("Mediatore ok, Ti presentiamo uno dei servizi presenti, decidi se approvarlo o meno(CODICE_SERVIZIO / N): \n\n")
        print(response.body)
        sleep(2)
        # non ci sono servizi da approvare
        if(response.body == "NON ci sono servizi al momento"):
            exit(0)
        approvazione = raw_input()
        if(approvazione!="N"):
            #richiesta di approvazione ..
            response = unirest.post(
                "http://localhost:8080/Site/MediatoreHandler",
                params={
                    "op" : "approvation",
                    "key" : codiceMediatore,
                    "serviceCode" : approvazione
                }
            )
            print("Servizio approvato. Lo notificheremo subito all'utente profesisonista offerente")
            # TODO notifica ...
        else:
            print("servizio non approvato, inserisci il punteggio di illegalita' (1/2)")
            p = raw_input()
            if(p=="1"):
                print("La non approvazione verra' notificata all'utente")
                # TODO notifica ...
            else:
                print("Il servizio verra' segnalato alle forze dell'ordine competenti")
                # TODO notifica alle forze dell'ordine ...

    # se la chiave NON e' corretta o ci sono stati errori
    else:
        print("Accesso non consentito")
        exit(0)
