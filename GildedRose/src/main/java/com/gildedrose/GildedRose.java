package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {

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
        
        case "Conjured":
            updateConjuredQuality(items[i]);
            break;

        default:
          updateDefaultItemQuality(items[i]);
          break;

      }
    }
  }

  
  private void updateAgedBrieQuality(Item item){
    if (item.quality < 50)
      item.quality++;
    
    item.sellIn--;
    if(item.sellIn < 0 && item.quality < 50)
      item.quality++;
    
  }

  private void updatedBackstagePassesQuality(Item item){
    if(item.quality < 50){
     
      item.quality++;
      
      if(item.sellIn < 11 && item.quality < 50)
        item.quality++;
      
      
      if(item.sellIn < 6 && item.quality < 50)
        item.quality++;
      
    }
    item.sellIn--;
    
    if(item.sellIn < 0)
      item.quality = 0;
    
  }

  private void updateConjuredQuality(Item item){
    if (item.quality > 0)
      item.quality -= 2;
    
    item.sellIn--;
    if (item.sellIn < 0 && item.quality > 0 )
      item.quality -= 2;
    
  }

  private void updateDefaultItemQuality(Item item){
   
    if (item.quality<50)
      item.quality -= 2;
    item.sellIn--;

    if (item.quality<0)
      item.quality = 0;
    

  }
}


