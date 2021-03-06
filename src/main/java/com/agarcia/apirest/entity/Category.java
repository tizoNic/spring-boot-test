/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agarcia.apirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pacisauctor
 */
@Entity
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findById", query = "SELECT c FROM Category c WHERE c.id = :id"),
    @NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name"),
    @NamedQuery(name = "Category.findByIsActive", query = "SELECT c FROM Category c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "Category.findByIsErased", query = "SELECT c FROM Category c WHERE c.isErased = :isErased"),
    @NamedQuery(name = "Category.findByDateCreated", query = "SELECT c FROM Category c WHERE c.dateCreated = :dateCreated"),
    @NamedQuery(name = "Category.findByLastModified", query = "SELECT c FROM Category c WHERE c.lastModified = :lastModified")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "is_active", columnDefinition = "BIT NOT NULL DEFAULT 1")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "is_erased", columnDefinition = "BIT NOT NULL DEFAULT 1")
    private boolean isErased;
    @Basic(optional = false)
    @Column(name = "date_created",columnDefinition="DATETIME DEFAULT GETDATE()")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @JsonIgnoreProperties("idCategory")
    @OneToMany(mappedBy = "idCategory")
    private List<Product> productList;

    public Category() {
    }

    public Category(Integer id) {
        this.id = id;
    }

    public Category(String name, boolean isActive, boolean isErased) {
        this.name = name;
        this.isActive = isActive;
        this.isErased = isErased;
    }
    

    public Category(Integer id, String name, boolean isActive, boolean isErased, Date dateCreated, Date lastModified) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.isErased = isErased;
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsErased() {
        return isErased;
    }

    public void setIsErased(boolean isErased) {
        this.isErased = isErased;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agarcia.apirest.entity.Category[ id=" + id + " ]";
    }
    
}
