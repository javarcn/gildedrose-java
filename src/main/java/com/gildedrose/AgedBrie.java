package com.gildedrose;

public class AgedBrie extends Item {

    public AgedBrie(int sellIn, int quality) {
        super(AGED_BRIE, sellIn, quality);
    }

    @Override
    protected boolean isAgedBrie() {
        return true;
    }

    @Override
    public void updateQualityExpiration() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    @Override
    protected void updateQuality() {

        if (quality < 50) {
            quality = quality + 1;

            if (isBackstagePass()) {
                if (sellIn < 11) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }

                if (sellIn < 6) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }
            }
        }

    }
}
