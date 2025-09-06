package Xyz;

    class Foods {
    	private String name;
    	private double price;


    	public Foods(String name, double price) {
    		this.name = name;
    		this.price = price;
    		
    	}

    	void setName(String name) {
    		this.name = name;
    	}

    	void setPrice(double price) {
    		this.price = price;
    	}



    	public String getName() {
    		return name;
    	}

    	public double getPrice() {
    	  return price;	
    		
    	}

    	
    	   @Override
    	    public String toString() {
    	        return "\n{Name: " + name + " Price: " + price + "}";
    	    }
    	
    	
    	
    	
    	
    	
    }