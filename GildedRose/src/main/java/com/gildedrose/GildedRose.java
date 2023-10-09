package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      // if (!items[i].name.equals("Aged Brie")
      //     && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      //   if (items[i].quality > 0) {
      //     if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
      //       items[i].quality = items[i].quality - 1;
      //     }
      //   }
      // } else {
      //   if (items[i].quality < 50) {
      //     items[i].quality = items[i].quality + 1;

      //     if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      //       if (items[i].sellIn < 11) {
      //         if (items[i].quality < 50) {
      //           items[i].quality = items[i].quality + 1;
      //         }
      //       }

      //       if (items[i].sellIn < 6) {
      //         if (items[i].quality < 50) {
      //           items[i].quality = items[i].quality + 1;
      //         }
      //       }
      //     }
      //   }
      // }

      // if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
      //   items[i].sellIn = items[i].sellIn - 1;
      // }

      // if (items[i].sellIn < 0) {
      //   if (!items[i].name.equals("Aged Brie")) {
      //     if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      //       if (items[i].quality > 0) {
      //         if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
      //           items[i].quality = items[i].quality - 1;
      //         }
      //       }
      //     } else {
      //       items[i].quality = items[i].quality - items[i].quality;
      //     }
      //   } else {
      //     if (items[i].quality < 50) {
      //       items[i].quality = items[i].quality + 1;
      //     }
      //   }
      // }

      switch (items[i].name){
        case "Aged Brie":
          updateAgedBrieQuality(items[i]);
          break;
        case "Backstage passes to a TAFKAL80ETC concert":
          updatedBackstagePassesQuality(items[i]);
          break;
        case "Sulfuras, Hand of Ragnaros" :
          //Legendary item, never has to be sold ot decreases in Quality
          break;
        // default: 
        //   updateDefaultItemQuality(items[i]);
        //   break;
      }
      //Decrease the sellIn value for all expcect "Sulfuras, Hand of Ragnaros"
      if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
        items[i].sellIn = items[i].sellIn - 1;
      }
    }
  }

  //update for "Aged brie items"
  private void updateAgedBrieQuality(Item item){
    if (item.quality<50){
      item.quality++;
    }
    item.sellIn--;
    //"Aged Brie" actually increases in Quality the older it gets
    if(item.sellIn<0 && item.quality<50){
      item.quality++;
    }
  }

  private void updatedBackstagePassesQuality(Item item){
    if(item.quality<50){
      //Increase 1 as sellIn value approaches
      item.quality++;
      //Quality increases by 2 when there are 10 days or less 
      if(item.sellIn<11 && item.quality<50){
        item.quality++;
      }
      //Quality inscreases by 3 when there are 5 days or less
      if(item.sellIn<6 && item.quality<50){
        item.quality++;
      }
    }
    item.sellIn--;
    //Quality drops to 0 after the concert
    if(item.sellIn<0){
      item.quality=0;
    }
  }

  // private void updateDefaultItemQuality(Item item){
  //   // Decrease quality for regular items (not "Sulfuras") when sellIn is positive
  //   if (item.quality > 0) {
  //     if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
  //       item.quality--;
  //     }
  //   }
  //   // Decrease sellIn for the item
  //   item.sellIn--;
  //   // If sellIn is negative and quality is still above 0 and not "Aged Brie," decrease quality
  //   if (item.sellIn < 0 && item.quality > 0 && !item.name.equals("Aged Brie")) {
  //     if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
  //       // Decrease quality for regular items (not "Sulfuras") when sellIn becomes negative
  //       if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
  //         item.quality--;
  //       }
  //     } else {
  //       // Reset quality to 0 for "Backstage passes" when sellIn becomes negative
  //       item.quality = 0;
  //     } 
  //   }
  // }
}

