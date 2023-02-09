public class Lot {
    private int lotNumber;
    private int currentBid,bidIncrement;
    private String description;
    private static int nextLotNum = 1001;
    private boolean sold;
    public Lot() {
        lotNumber = nextLotNum++;
        description = "Unknown item";
        currentBid = 0;
        bidIncrement = 0;
        sold = false;
    }
    public Lot(String description, int startingBid, int bidIncrement) {
        lotNumber = nextLotNum++;
        this.description = description;
        this.currentBid = startingBid;
        this.bidIncrement = bidIncrement;
        sold = false;
    }
    public void markSold() {
        sold = true;
    }
    public boolean getSold() {
        return sold;
    }
    public int getBidIncrement() {
        return bidIncrement;
    }
    public String getDescription() {
        return description;
    }
    public void setCurrentBid(int currentBid) {
        this.currentBid = currentBid;
    }
    public int nextBid() {
        return currentBid+ bidIncrement;
    }
    @Override
    public String toString() {
        if (sold) {
            return "Lot " +  this.lotNumber + ". " + this.description +" was sold for $" + this.currentBid;
        }
        else {return "Lot " + this.lotNumber + ". " + this.description+ " current bid: $"+this.currentBid+ " minimum bid: $"
                + nextBid();}
    }
}