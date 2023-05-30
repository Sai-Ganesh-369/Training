package io.endeavourtech.stocks.vo;

public class SectorLookup {
    private  int sectorId;
    private String sectorName;

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    @Override
    public String toString() {
        return "SectorLookup{" +
                "sectorId=" + sectorId +
                ", sectorName='" + sectorName + '\'' +
                '}';
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getSectorName() {
        return sectorName;
    }
}
