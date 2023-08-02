<?php
    require_once('Database.php');

    $db = new Database();
    $articles = $db->getArtikel();
    $angestellte = $db->getAngestellte();
    $benutzer = $db->getBenutzer();
?>

<!DOCTYPE html>
<html lang="en">

<head>
  <title>Jump to Users</title>
<link rel="stylesheet" href="styles.css" />
</head>
<body>
<header>
  <h1>Martina's Shop</h1>
</header>
  <main>
    <?php include "table3.php"; ?>
  </main>
</body>
</html>
