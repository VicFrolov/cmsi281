public class NumberList implements java.util.Collection {
	private Long[] numberList;
	private int count;


    public NumberList() {
    	this.numberList = new Long[1];
    	count = 0;
	}


    public NumberList(Long[] l) {
    	this.count = l.length;
    	this.numberList = new Long[l.length * 2];

    	for (int i = 0; i < l.length; i++) {
    		this.numberList[i] = l[i];
    	}
    }
    

    public boolean add (Object obj) {
    	int nlLength = this.numberList.length;
    	int countArray = 0;

        if(obj == null) {
            throw new NullPointerException();
        } else if (!(obj instanceof Long)) {
    		return false;
    	} else {
        	for (int i = 0; i < nlLength; i++) {
        		if (this.numberList[i] == null) {
        			this.numberList[i] = (Long) obj;
        			count++;
        			break;
        		} else if (countArray == this.count || this.count == nlLength) {
        			Long[] tempNl = new Long[nlLength * 2];

        			for (int j = 0; j < nlLength; j++) {
        				tempNl[j] = this.numberList[j];
        			}
        			tempNl[nlLength] = (Long) obj;
        			this.numberList = tempNl;
        			this.count++;
        			break;
        		}
        		countArray++;
        	}
        }
	    return true;
    }
    

    public boolean addAll(java.util.Collection c) {

        if ((NumberList) c == null) {
            throw new NullPointerException();
        } else if (!(c instanceof NumberList)) {
            return false;
        } else if (((NumberList) c).sizeIncludingDuplicates() == 0) {
            return true;
        }

        String stringifiedC = ((NumberList) c).toString();
        String[] elementsOfC = (stringifiedC.substring(1, stringifiedC.length() -1)).split(", ");

        for(int i = 0; i < elementsOfC.length; i++) {
            this.add(new Long(Long.parseLong(elementsOfC[i])));
        }

        return true;
    }

 
    public void clear () {
        Long[] tempNl = new Long[1];
        this.count = 0;
        this.numberList = tempNl;
    }


    public boolean contains(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        } else if (!(obj instanceof Long)) {
            throw new ClassCastException();
        } else {
            for (int i = 0; i < this.numberList.length; i++) {
                if ( ((Long) obj).equals(this.numberList[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    //helper method that converts a numberList into a long[]
    public long[] convertNl( java.util.Collection c) {

        String stringifiedC = ((NumberList) c).toString();
        String[] elementsOfC = (stringifiedC.substring(1, stringifiedC.length() -1)).split(", ");
        long[] longsOfC = new long[((NumberList) c).sizeIncludingDuplicates()];

        for(int i = 0; i < elementsOfC.length; i++) {
            longsOfC[i] = Long.parseLong(elementsOfC[i]);
        }

        return longsOfC;
    }
 

    public boolean containsAll ( java.util.Collection c ) {
        long[] elementsOfC;
        boolean containsAllVals = false;

        if ((NumberList) c == null) {
            throw new NullPointerException();
        } else if (!(c instanceof NumberList) || (this.count == 0 && ((NumberList) c).sizeIncludingDuplicates() != 0)) {
            return false;
        } else if ( ((NumberList) c).sizeIncludingDuplicates() == 0) {
            return true;
        } else {
            elementsOfC = convertNl(c);
            int contains = 0;

            //i goes over every element in c, and j goes over every element in this list
            for (int i = 0; i < elementsOfC.length; i++) {
                for (int j = 0; j < this.count; j++) {
                    if (this.numberList[j] == elementsOfC[i]) {
                        contains++;
                        break;
                    }
                }
            }

            if (contains == elementsOfC.length) {
                containsAllVals = true;
            } else {
                containsAllVals = false;
            }
            return containsAllVals;
        }
    }
 
 

    public boolean equals(Object obj) {
        if (!(obj instanceof NumberList)) {
            return false;    
        } else {
            return this.toString().equals(obj.toString()) ? true : false;
        }
    }



    /** Returns the hashcode value for this collection. */
    public int hashCode () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }



    public boolean isEmpty () {
    	return (count == 0) ? true : false;
    }



    /** Returns an iterator over the elements in this collection. Replicated elements should
        be "iterated over" just once. */
    public java.util.Iterator iterator () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }



    public boolean remove ( Object obj ) {
        Long[] tempNl = new Long[this.numberList.length];
        int indexOfRemovedValue = 0;
        if (!(obj instanceof Long)) {
            throw new ClassCastException();
        } else if (obj == null) {
            throw new NullPointerException();
        } else if (count == 0) {
            return false;
        } else {
            for (int i = 0; i < this.numberList.length; i++) {

                if (((Long) obj).equals(this.numberList[i])) {
                    indexOfRemovedValue = i;

                    //copying over all values before the removed value
                    for (int j = 0; j < i; j++) {
                        tempNl[j] = this.numberList[j];
                    }

                    // copying over all values after the removed value
                    for(indexOfRemovedValue = indexOfRemovedValue; indexOfRemovedValue < count - 1; indexOfRemovedValue++) {
                        tempNl[indexOfRemovedValue] = this.numberList[indexOfRemovedValue + 1];
                    }

                    count--;
                    this.numberList = tempNl;
                    
                    return true;
                }
            }
        }
        return false;
    }


    public boolean removeAll ( java.util.Collection c ) {
        long[] elementsOfC;
        boolean containsAllVals = false;

        if ((NumberList) c == null) {
            throw new NullPointerException();
        } else if (!(c instanceof NumberList)) {
            return false;
        } else if ( ((NumberList) c).sizeIncludingDuplicates() == 0 || (this.count == 0)) {
            return true;
        } else {
            elementsOfC = convertNl(c);

            //i goes over every element in c, and j goes over every element in this list
            for (int i = 0; i < elementsOfC.length; i++) {
                for (int j = 0; j < this.count; j++) {
                    while (this.contains(new Long(elementsOfC[i]))) {
                        this.remove(elementsOfC[i]);
                    }
                }
            }
            return true;
        }
    }



	/** Retains only the elements in this collection that are contained in the specified collection. 
		 In other words, removes from this collection all of its elements that are not contained in the 
		 specified collection. */
	public boolean retainAll ( java.util.Collection c ) {
		throw new UnsupportedOperationException();
	}


    public int sizeIncludingDuplicates() {
    	return this.count;
    }
    
    

    /** Returns a Long[] containing all of the elements in this collection, not including duplicates. */
    public Long[] toArray() {
        Long[] tempN = new Long[]{};
        NumberList tempNl = new NumberList(this.numberList);

        if (this.count == 0) {
            return tempN;
        }
        return tempN;  
    }



    /** Not supported for this class. */
    public Object[] toArray ( Object[] obj ) {
        throw new UnsupportedOperationException();
    }


    public int size () {
        NumberList tempNl = new NumberList();

        int sizeNoRepeating = 0;
        for (int i = 0; i < count; i++) {
            boolean uniqueElement = true;

            for (int j = 0; j < count; j++) {

                if(numberList[i].equals(numberList[j]) && i != j) {
                    uniqueElement = false;                    
                    //check to see if the temp NumberList contains this value as it is a duplicate
                    if (!tempNl.contains(numberList[j])) {
                        tempNl.add(numberList[j]);
                    }
                }
            }
            if (uniqueElement == true) {
                sizeNoRepeating++;
            }
        }
        // add all of the missing repeated values;
        sizeNoRepeating += tempNl.sizeIncludingDuplicates();

        return sizeNoRepeating;
    }


    public int count(Object obj) {
    	int tally = 0;
    	for (int i = 0; i < this.count; i++) {
    		if (this.numberList[i].equals((Long) obj)) {
    			tally++;
    		}
    	}
    	return tally;
    }
    

	@Override
	public String toString () {
        String stringifiedArray = "[";
        for (int i = 0; i < this.count; i++) {
        	if (i == this.count - 1) {
        		stringifiedArray += (this.numberList[i].toString());
        	} else {
        		stringifiedArray += (this.numberList[i].toString()) + ", ";
        	}

        }
        stringifiedArray += "]";

        return stringifiedArray;
    }


    public static NumberList fromArray ( long[] l ) {
        NumberList tempNl = new NumberList();

        for(int i = 0; i < l.length; i++) {
            tempNl.add(new Long(l[i]));
        }
        return tempNl;
    }

    
    public static void main ( String[] args ) {
        // Please see NumberListTestHarness.java for tests

    	NumberListTestHarness.main(new String[]{"test away!"});   

	}
    
}