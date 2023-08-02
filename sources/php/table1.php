      <table>
        <thead>
          <th>Product</th>
          <th class="narrow">Size</th>
          <th class="narrow">Weight</th>
          <th class="right narrow">Price</th>
        </thead>
        <tbody>
        <?php foreach($articles as $key=>$value){ ?>
            <tr>
                <td>
                <?php echo $value['ART_NAME']; ?>
                <div class="tag"><?php echo $value['BEZEICHNUNG']; ?></div>
                </td>
                <td class="narrow"><?php echo $value['GROESSE']; ?> cm</td>
                <td class="narrow"><?php echo $value['GEWICHT']; ?> g</td>
                <td class="right narrow"><?php echo $value['PREIS']; ?> $</td>
            </tr>
        <?php } ?>
        </tbody>
      </table>
