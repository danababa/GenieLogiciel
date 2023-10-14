package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
  Item element = new Item("foo", 0, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals("foo", element.name, "the name changed");
  }

  @Test 
  @DisplayName("Test name is not Aged Brie ")
  void testAgedBrie(){
  Item element = new Item("Aged Brie", 0, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals("Aged Brie", element.name, "different name");
  }

  @Test 
  @DisplayName("Test name of Backstage passes ")
  void testBackstage(){
  Item element = new Item("Backstage passes to a TAFKAL80ETC concert",0, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals("Backstage passes to a TAFKAL80ETC concert", element.name, "same name");
  }

  //Test if quality is greater than 0
  @Test 
  @DisplayName("Test quality > 0 ")
  void testQuality(){
  Item element = new Item("foo", 0, 2);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(0, element.quality, "quantity less than zero");
  }

  //Test if quality is less than 0
  @Test 
  @DisplayName("Test quality = 0 ")
  void testQuality2(){
  Item element = new Item("foo", 0, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(0, element.quality, "quantity equal to zero");
  }


  // Test the name Sulfuras, Hand of Ragnaros
  @Test 
  @DisplayName("Test Sulfuras, Hand of Ragnaros")
  void testName2(){
  Item element = new Item("Sulfuras, Hand of Ragnaros", 0, 49);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals("Sulfuras, Hand of Ragnaros", element.name, "different name");
  }

  // Test if quality is > 50 if name is Backstage passes to a TAFKAL80ETC concert
  @Test 
  @DisplayName("Test quality > 50 if name is Backstage passes to a TAFKAL80ETC concert ")
  void testLT(){
  Item element= new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(50, element.quality, "quality greater than fifty and name is Backstage passes to a TAFKAL80ETC concert");
  }

  @Test 
  @DisplayName("Test quality < 50 with sellIn > 0 ")
  void testLT3(){
  Item element= new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(50, element.quality, "quality greater than fifty and sellIn greater than 0");
  }

  @Test 
  @DisplayName("Test quality > 50 with sellIn > 0")
  void testGT3(){
  Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 51);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(51, element.quality, "quality greater than fifty");
  }

  @Test 
  @DisplayName("Test Quality = 50")
  void testSell6(){
  Item element = new Item("Sulfuras, Hand of Ragnaros", 0, 50);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(50, element.quality, "quality equal to fifty");
  }

  @Test 
  @DisplayName("Test quality < 50 with name Aged Brie")
  void testGTRand(){
  Item element = new Item("Aged Brie", -1, 49);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(50, element.quality, "quality less than fifty");
  }

  @Test 
  @DisplayName("Test SellIn < 11 ")
  void testSellInLT(){
  Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(8, element.sellIn, "SellIn less than eleven");
  }
  
  @Test 
  @DisplayName("Test SellIn < 11 avec nom different que Backstage ")
  void testSellInLTAged(){
  Item element = new Item("Aged Brie", 9, 0);
  GildedRose app = new GildedRose(new Item[] {element});
  app.updateQuality();
  assertEquals(1, element.quality, "SellIn less than eleven with name Aged Brie");
  }

  @Test 
  @DisplayName("Test SellIn > 11 ")
  void testSellInGT(){
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(11, element.sellIn, "SellIn greater than eleven");
  }
  
  @Test 
  @DisplayName("Test SellIn = 11 and Quality < 50 ")
  void testSellInEqT(){
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(11, element.quality, "sellIn equal to eleven");
  }

  @Test 
  @DisplayName("Test items[i].quality = items[i].quality + 1; ")
  void testSellInEq11(){
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "add 1 to quality");
  }

  @Test 
  @DisplayName("Test SellIn = 6 and Quality < 50 ")
  void testSellInEqT6(){
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(12, element.quality, "sellIn equal to six");
  }
  
  @Test 
  @DisplayName("Test SellIn < 6 and Quality < 50 ")
  void testSellInEq6(){
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 46);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(49, element.quality, "sellIn less than 5");
  }

  @Test 
  @DisplayName("Test SellIn < 0 ")
  void testSellNeg(){
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "sellIn less than 0");
  }

  @Test 
  @DisplayName("Test quality -1 ")
  void testQualitySub(){
    Item element = new Item("Aged Brie", -1, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "sellIn equal to eleven");
  }
  
  @Test 
  @DisplayName("Test toString")
  void toStringTest(){
  Item element = new Item("Aged Brie", 12, 0);
  assertEquals("Aged Brie, 12, 0", element.toString(), "name not in correct format");
  }

  @Test
  @DisplayName("Test Conjured item quality decreases by 2 when sellIn is positive")
  void testConjuredSellInPos(){
    Item conjured = new Item("Conjured",5,10);
    GildedRose app = new GildedRose(new Item[]{conjured});
    app.updateQuality();
    assertEquals(8,conjured.quality,"Quality should decrease by 2 when sellIn is positive"); 
  }

  @Test
  @DisplayName("Test Conjured item quality decreases by 4 when sellIn is negative")
  void testConjuredSellInNeg(){
    Item conjured = new Item("Conjured",-1,10);
    GildedRose app = new GildedRose(new Item[]{conjured});
    app.updateQuality();
    assertEquals(6,conjured.quality,"Quality should decrease by 4 when sellIn is negative"); 
  }

}

