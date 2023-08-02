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
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Martina's Shop</title>

    <link rel="stylesheet" href="styles.css" />

    <script>
      window.onload = () => {
        const openBtn = document.querySelector(".open-dialog-btn");
        const closeBtn = document.querySelector(".close-btn");
        const formDialog = document.querySelector(".form-dialog");

        openBtn.addEventListener("click", () => {
          formDialog.classList.add("open");
        });

        closeBtn.addEventListener("click", (e) => {
          formDialog.classList.remove("open");
        });
      };
    </script>
  </head>
  <body>
    <header>
      <h1>Martina's Shop</h1>
      <button class="button open-dialog-btn">SELL ITEM</button>
    </header>

    <div class="form-dialog">
      <div class="dialog-content">
        <h3>Sell Your ITEM</h3>
        <form action="/~martinao98/createArticle.php" method="POST">
          <div>
            <label for="ART_NAME">Item Name*</label>
            <input required type="text" name="ART_NAME" id="ART_NAME" />
          </div>

          <div>
            <label for="BEZEICHNUNG">Description*</label>
            <input required type="text" name="BEZEICHNUNG" id="BEZEICHNUNG" />
          </div>

          <div>
            <label for="PREIS">Price*</label>
            <input required type="number" name="PREIS" id="PREIS" />
          </div>

          <div>
            <label for="GROESSE">Size*</label>
            <input required type="number" name="GROESSE" id="GROESSE" />
          </div>

          <div>
            <label for="GEWICHT">Weight*</label>
            <input required type="number" name="GEWICHT" id="GEWICHT" />
          </div>
          <button class="button" type="submit">SELL</button>
          <button class="button close-btn" type="button">CLOSE</button>
        </form>
      </div>
    </div>

<form action="/~martinao98/search.php" method="GET">
  <input required type="text" name="ART_NAME" placeholder="Search an item...">
  <button class="button" type="submit">SEARCH</button>
</form>

    <main>
<?php include "table1.php"; ?>
<a href="second_page.php">Jump to Employees</a><br/>
<a href="third_page.php">Jump to Users</a><br/>
    </main>

    <footer>Thanks for visiting my Shop!</footer>
  </body>
</html>
