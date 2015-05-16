package betterjavac.java;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private Address address;
    private boolean enabled;
    private boolean provisioned;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, boolean enabled, boolean provisioned) {
        this.userName = userName;
        this.enabled = enabled;
        this.provisioned = provisioned;
    }

    public User(String userName, String firstName, String lastName, boolean enabled, boolean provisioned) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.provisioned = provisioned;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFullName() {
        if (isNotEmpty(firstName) && isNotEmpty(lastName)) {
            return firstName + ' ' + lastName;
        }
        return isNotEmpty(firstName) ? firstName : isNotEmpty(lastName) ? lastName : "";
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isProvisioned() {
        return provisioned;
    }

    public void setProvisioned(boolean provisioned) {
        this.provisioned = provisioned;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
