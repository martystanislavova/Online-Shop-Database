<link rel="stylesheet" href="styles.css" />
<?php
    require_once('Database.php');

   
    if (isset($_GET['ART_NAME'])) {
     $ART_NAME = $_GET['ART_NAME'];
     $db = new Database();
     $articles = $db->searchArtikel($ART_NAME);
    } else {
        $articles = [];
       }
?>

<style>
  table {
    border-collapse: collapse;
    width: 100%;
  }
  th, td {
    border: 1px solid #ddd;
    text-align: left;
    padding: 8px;
  }
  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
  th {
    background-color: #E82AC2;
    color: black;
  }
</style>

<table>
<link rel="stylesheet" href="styles.css" />
  <thead>
    <caption>Items</caption>
    <th>Product</th>
    <th>Size</th>
    <th>Weight</th>
    <th>Price</th>
  </thead>
  <tbody>
    <?php if (isset($articles)): ?>
      <?php foreach ($articles as $article): ?>
        <tr>
          <td class="narrow"><?php echo $article['ART_NAME']; ?></td>
          <td class="narrow"><?php echo $article['GROESSE']; ?> cm</td>
          <td class="narrow"><?php echo $article['GEWICHT']; ?> g</td>
          <td class="narrow"><?php echo $article['PREIS']; ?> $</td>
        </tr>
      <?php endforeach; ?>
    <?php else: ?>
      <tr>
        <td colspan="4">No articles found</td>
      </tr>
    <?php endif; ?>
  </tbody>
</table>

<a href="index.php">go back :)</a>

