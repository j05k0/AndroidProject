package com.example.jozef.predajelektroniky.data;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Products
{
  private String InternalMemory;
  private Double ScreenSize;
  private String OperatingSystem;
  private String PictureURL;
  private String objectId;
  private String ScreenResolution;
  private String CPU;
  private String Category;
  private String ownerId;
  private java.util.Date updated;
  private Double Price;
  private String Model;
  private Integer RAM;
  private java.util.Date created;
  private String Brand;
  public String getInternalMemory()
  {
    return InternalMemory;
  }

  public void setInternalMemory( String InternalMemory )
  {
    this.InternalMemory = InternalMemory;
  }

  public Double getScreenSize()
  {
    return ScreenSize;
  }

  public void setScreenSize( Double ScreenSize )
  {
    this.ScreenSize = ScreenSize;
  }

  public String getOperatingSystem()
  {
    return OperatingSystem;
  }

  public void setOperatingSystem( String OperatingSystem )
  {
    this.OperatingSystem = OperatingSystem;
  }

  public String getPictureURL()
  {
    return PictureURL;
  }

  public void setPictureURL( String PictureURL )
  {
    this.PictureURL = PictureURL;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getScreenResolution()
  {
    return ScreenResolution;
  }

  public void setScreenResolution( String ScreenResolution )
  {
    this.ScreenResolution = ScreenResolution;
  }

  public String getCPU()
  {
    return CPU;
  }

  public void setCPU( String CPU )
  {
    this.CPU = CPU;
  }

  public String getCategory()
  {
    return Category;
  }

  public void setCategory( String Category )
  {
    this.Category = Category;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public Double getPrice()
  {
    return Price;
  }

  public void setPrice( Double Price )
  {
    this.Price = Price;
  }

  public String getModel()
  {
    return Model;
  }

  public void setModel( String Model )
  {
    this.Model = Model;
  }

  public Integer getRAM()
  {
    return RAM;
  }

  public void setRAM( Integer RAM )
  {
    this.RAM = RAM;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getBrand()
  {
    return Brand;
  }

  public void setBrand( String Brand )
  {
    this.Brand = Brand;
  }

                                                    
  public Products save()
  {
    return Backendless.Data.of( Products.class ).save( this );
  }

  public Future<Products> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Products> future = new Future<Products>();
      Backendless.Data.of( Products.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Products> callback )
  {
    Backendless.Data.of( Products.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Products.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( Products.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Products.class ).remove( this, callback );
  }

  public static Products findById( String id )
  {
    return Backendless.Data.of( Products.class ).findById( id );
  }

  public static Future<Products> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Products> future = new Future<Products>();
      Backendless.Data.of( Products.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Products> callback )
  {
    Backendless.Data.of( Products.class ).findById( id, callback );
  }

  public static Products findFirst()
  {
    return Backendless.Data.of( Products.class ).findFirst();
  }

  public static Future<Products> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Products> future = new Future<Products>();
      Backendless.Data.of( Products.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Products> callback )
  {
    Backendless.Data.of( Products.class ).findFirst( callback );
  }

  public static Products findLast()
  {
    return Backendless.Data.of( Products.class ).findLast();
  }

  public static Future<Products> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Products> future = new Future<Products>();
      Backendless.Data.of( Products.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Products> callback )
  {
    Backendless.Data.of( Products.class ).findLast( callback );
  }

  public static BackendlessCollection<Products> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Products.class ).find( query );
  }

  public static Future<BackendlessCollection<Products>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Products>> future = new Future<BackendlessCollection<Products>>();
      Backendless.Data.of( Products.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Products>> callback )
  {
    Backendless.Data.of( Products.class ).find( query, callback );
  }
}