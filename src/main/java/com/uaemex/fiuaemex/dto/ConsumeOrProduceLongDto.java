
package com.uaemex.fiuaemex.dto;


public class ConsumeOrProduceLongDto {
    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConsumeLongDto{" + "value=" + value + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (this.value ^ (this.value >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConsumeOrProduceLongDto other = (ConsumeOrProduceLongDto) obj;
        return this.value == other.value;
    }
    
    
}
