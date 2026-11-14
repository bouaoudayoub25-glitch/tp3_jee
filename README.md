# tp3_jee

TP3 : Reponses aux questions

Question 1 : forward ou sendRedirect au login ?
Echec : forward. La meme requete continue, donc on peut envoyer le message d'erreur.
Succes : sendRedirect. Nouvelle requete vers le Dashboard. La session garde l'utilisateur connecte, et F5 ne renvoie pas le formulaire.
Question 2 : F5 apres l'ajout d'un produit
(a) Forward. F5 rejoue le POST : le produit est ajoute deux fois.
(b) Redirect. F5 rejoue seulement le GET de la liste : pas de doublon.
Pattern : PRG (Post / Redirect / Get).
Question 3 : XSS
Sans c:out (${produit.nom}) : le script s'execute.
Avec c:out : le script devient du texte, il ne s'execute pas.
Conclusion. Toujours afficher les donnees saisies avec c:out.
Question 4 : filtre ou verification dans chaque servlet ?
Avantages du filtre.
1.  Pas de repetition : le test est ecrit une seule fois.
2.  Maintenance facile : un seul fichier a modifier.
