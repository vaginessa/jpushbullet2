package net.iharder.jpushbullet2;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.lang.reflect.Field;


/**
 * Represents a Pushbullet device that has been converted from a json response
 * from the Pushbullet servers.
 * @author Robert.Harder
 */
public class Device implements Comparable<Device> {
    private Number id;
    private String iden;
    private String nickname;
    private String fingerprint;
    private String type;
    private String push_token;
    private String app_version;
    private String manufacturer;
    private double created;
    private double modified;
    private String model;
    private boolean active;
    private boolean pushable;
    
    
    public double getModified() {
        return modified;
    }

    public String getPush_token() {
        return push_token;
    }

    public String getType() {
        return type;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public String getNickname() {
        return nickname;
    }

    public Number getId(){
            return this.id;
    }

    public String getIden(){
            return this.iden;
    }

    public String getApp_version() {
        return app_version;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getCreated() {
        return created;
    }

    public String getModel() {
        return model;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isPushable() {
        return pushable;
    }

    @Override
    public int compareTo(Device o) {
        Device other = (Device) o;
        return new CompareToBuilder()
            .append(this.iden, other.iden)
            .toComparison();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() != getClass()) {
            return false;
        }

        Device rhs = (Device) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(iden, rhs.iden)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(iden).toHashCode();
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append( "{").append(this.getClass().getSimpleName());
        for( Field f : this.getClass().getDeclaredFields() ){
            s.append(", ");
            s.append( f.getName() ).append("=");
            try {
                s.append( f.get(this) );
            } catch (Exception ex) {
                //Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        s.append("}");
        return s.toString();
    }
    
}   // end class Device
