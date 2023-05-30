package io.endeavourtech.stocks.vo;

public class SubSectorLookUp {
    private int subSectorId;

    @Override
    public String toString() {
        return "SubSectorLookUp{" +
                "subSectorId=" + subSectorId +
                ", sectorName='" + sectorName + '\'' +
                '}';
    }

    private String sectorName;

    public int getSubSectorId() {
        return subSectorId;
    }

    public void setSubSectorId(int subSectorId) {
        this.subSectorId = subSectorId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }



}
