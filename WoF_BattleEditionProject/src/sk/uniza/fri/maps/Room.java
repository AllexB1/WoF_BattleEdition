package sk.uniza.fri.maps;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class Room {
    private String description;
    private Room leftExit;
    private Room middleExit;
    private Room rightExit;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne
     * charakterizuje.
     *
     * @param popis text popisu miestnosti.
     */
    public Room(String popis) {
        this.description = popis;
    }

    /**
     * Nastavi vychody z miestnosti. Kazdy vychod je urceny bud odkazom
     * na miestnost alebo hodnotou null, ak vychod tym smerom neexistuje.
     *
     * @param leftExit miestnost smerom na sever.
     * @param middleExit miestnost smerom na vychod.
     * @param rightExit miestnost smerom na juh.
     */
    public void setExits(Room leftExit, Room middleExit, Room rightExit) {
        if (leftExit != null) {
            this.leftExit = leftExit;
        }
        if (middleExit != null) {
            this.rightExit = middleExit;
        }
        if (rightExit != null) {
            this.middleExit = rightExit;
        }
    }

    /**
     * @return textovy popis Miestnosti.
     */
//    public String getPopis() {
//        StringBuilder sb = new StringBuilder();
//        String popis = "\nV Miestnosti sa nachadzaju tieto predmety: ";
//        sb.append(popis);
//        for (IInteractable item : items) {
//            sb.append(item.getName());
//            sb.append(" ");
//        }
//
//        return this.description + sb.toString();
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getLeftExit() {
        return leftExit;
    }

    public void setLeftExit(Room leftExit) {
        this.leftExit = leftExit;
    }

    public Room getMiddleExit() {
        return middleExit;
    }

    public void setMiddleExit(Room middleExit) {
        this.middleExit = middleExit;
    }

    public Room getRightExit() {
        return rightExit;
    }

    public void setRightExit(Room rightExit) {
        this.rightExit = rightExit;
    }
}
