public class Item {
    private final String code;
    private final String name;
    private final String maker;
    private final int price;
    public Item(String code, String name, String maker, int price) {
        super();
        this.code = code;
        this.name = name;
        this.maker = maker;
        this.price = price;
    }

    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getMaker() {
        return maker;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0: code.hashCode());
        result = prime * result + ((maker == null) ? 0: maker.hashCode());
        result = prime * result + ((name == null) ? 0: name.hashCode());
        result = prime * result + price;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Item other = (Item) obj;

        if (code == null) {
            if (other.code != null){
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }

        if (maker == null) {
            if (other.maker != null) {
                return false;
            }
        } else if (!maker.equals(other.maker)) {
            return false;
        }

        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
                return false;
        }

        if (price != other.price) return false;

        return true;
    }
}
