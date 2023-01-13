/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.learnavro.domain.generated;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class CoffeeOrder extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1317713370964809722L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CoffeeOrder\",\"namespace\":\"com.learnavro.domain.generated\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"fullName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"nickName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Optional field represents the nickName of the user\",\"default\":\"\"},{\"name\":\"nickName1\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Optional field represents the nickName of the user\",\"default\":\"\"},{\"name\":\"store\",\"type\":{\"type\":\"record\",\"name\":\"Store\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"address\",\"type\":{\"type\":\"record\",\"name\":\"Address\",\"fields\":[{\"name\":\"addressLine1\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"city\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"state_province\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"country\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"USA\"},{\"name\":\"zip\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}}]}},{\"name\":\"orderLineItems\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"OrderLineItem\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"size\",\"type\":{\"type\":\"enum\",\"name\":\"Size\",\"symbols\":[\"SMALL\",\"MEDIUM\",\"LARGE\"]}},{\"name\":\"quantity\",\"type\":\"int\"},{\"name\":\"cost\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":3,\"scale\":2}}]}}},{\"name\":\"pick_up\",\"type\":{\"type\":\"enum\",\"name\":\"PickUp\",\"symbols\":[\"IN_STORE\",\"CURBSIDE\"]}},{\"name\":\"ordered_time\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"status\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"NEW\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();
static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.UUIDConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
  }

  private static final BinaryMessageEncoder<CoffeeOrder> ENCODER =
      new BinaryMessageEncoder<CoffeeOrder>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CoffeeOrder> DECODER =
      new BinaryMessageDecoder<CoffeeOrder>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CoffeeOrder> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CoffeeOrder> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CoffeeOrder> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CoffeeOrder>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CoffeeOrder to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CoffeeOrder from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CoffeeOrder instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CoffeeOrder fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.util.UUID id;
  @Deprecated public java.lang.String fullName;
  /** Optional field represents the nickName of the user */
  @Deprecated public java.lang.String nickName;
  /** Optional field represents the nickName of the user */
  @Deprecated public java.lang.String nickName1;
  @Deprecated public com.learnavro.domain.generated.Store store;
  @Deprecated public java.util.List<com.learnavro.domain.generated.OrderLineItem> orderLineItems;
  @Deprecated public com.learnavro.domain.generated.PickUp pick_up;
  @Deprecated public java.time.Instant ordered_time;
  @Deprecated public java.lang.String status;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CoffeeOrder() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param fullName The new value for fullName
   * @param nickName Optional field represents the nickName of the user
   * @param nickName1 Optional field represents the nickName of the user
   * @param store The new value for store
   * @param orderLineItems The new value for orderLineItems
   * @param pick_up The new value for pick_up
   * @param ordered_time The new value for ordered_time
   * @param status The new value for status
   */
  public CoffeeOrder(java.util.UUID id, java.lang.String fullName, java.lang.String nickName, java.lang.String nickName1, com.learnavro.domain.generated.Store store, java.util.List<com.learnavro.domain.generated.OrderLineItem> orderLineItems, com.learnavro.domain.generated.PickUp pick_up, java.time.Instant ordered_time, java.lang.String status) {
    this.id = id;
    this.fullName = fullName;
    this.nickName = nickName;
    this.nickName1 = nickName1;
    this.store = store;
    this.orderLineItems = orderLineItems;
    this.pick_up = pick_up;
    this.ordered_time = ordered_time.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.status = status;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return fullName;
    case 2: return nickName;
    case 3: return nickName1;
    case 4: return store;
    case 5: return orderLineItems;
    case 6: return pick_up;
    case 7: return ordered_time;
    case 8: return status;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      new org.apache.avro.Conversions.UUIDConversion(),
      null,
      null,
      null,
      null,
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.util.UUID)value$; break;
    case 1: fullName = value$ != null ? value$.toString() : null; break;
    case 2: nickName = value$ != null ? value$.toString() : null; break;
    case 3: nickName1 = value$ != null ? value$.toString() : null; break;
    case 4: store = (com.learnavro.domain.generated.Store)value$; break;
    case 5: orderLineItems = (java.util.List<com.learnavro.domain.generated.OrderLineItem>)value$; break;
    case 6: pick_up = (com.learnavro.domain.generated.PickUp)value$; break;
    case 7: ordered_time = (java.time.Instant)value$; break;
    case 8: status = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.util.UUID getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.util.UUID value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'fullName' field.
   * @return The value of the 'fullName' field.
   */
  public java.lang.String getFullName() {
    return fullName;
  }


  /**
   * Sets the value of the 'fullName' field.
   * @param value the value to set.
   */
  public void setFullName(java.lang.String value) {
    this.fullName = value;
  }

  /**
   * Gets the value of the 'nickName' field.
   * @return Optional field represents the nickName of the user
   */
  public java.lang.String getNickName() {
    return nickName;
  }


  /**
   * Sets the value of the 'nickName' field.
   * Optional field represents the nickName of the user
   * @param value the value to set.
   */
  public void setNickName(java.lang.String value) {
    this.nickName = value;
  }

  /**
   * Gets the value of the 'nickName1' field.
   * @return Optional field represents the nickName of the user
   */
  public java.lang.String getNickName1() {
    return nickName1;
  }


  /**
   * Sets the value of the 'nickName1' field.
   * Optional field represents the nickName of the user
   * @param value the value to set.
   */
  public void setNickName1(java.lang.String value) {
    this.nickName1 = value;
  }

  /**
   * Gets the value of the 'store' field.
   * @return The value of the 'store' field.
   */
  public com.learnavro.domain.generated.Store getStore() {
    return store;
  }


  /**
   * Sets the value of the 'store' field.
   * @param value the value to set.
   */
  public void setStore(com.learnavro.domain.generated.Store value) {
    this.store = value;
  }

  /**
   * Gets the value of the 'orderLineItems' field.
   * @return The value of the 'orderLineItems' field.
   */
  public java.util.List<com.learnavro.domain.generated.OrderLineItem> getOrderLineItems() {
    return orderLineItems;
  }


  /**
   * Sets the value of the 'orderLineItems' field.
   * @param value the value to set.
   */
  public void setOrderLineItems(java.util.List<com.learnavro.domain.generated.OrderLineItem> value) {
    this.orderLineItems = value;
  }

  /**
   * Gets the value of the 'pick_up' field.
   * @return The value of the 'pick_up' field.
   */
  public com.learnavro.domain.generated.PickUp getPickUp() {
    return pick_up;
  }


  /**
   * Sets the value of the 'pick_up' field.
   * @param value the value to set.
   */
  public void setPickUp(com.learnavro.domain.generated.PickUp value) {
    this.pick_up = value;
  }

  /**
   * Gets the value of the 'ordered_time' field.
   * @return The value of the 'ordered_time' field.
   */
  public java.time.Instant getOrderedTime() {
    return ordered_time;
  }


  /**
   * Sets the value of the 'ordered_time' field.
   * @param value the value to set.
   */
  public void setOrderedTime(java.time.Instant value) {
    this.ordered_time = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Gets the value of the 'status' field.
   * @return The value of the 'status' field.
   */
  public java.lang.String getStatus() {
    return status;
  }


  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(java.lang.String value) {
    this.status = value;
  }

  /**
   * Creates a new CoffeeOrder RecordBuilder.
   * @return A new CoffeeOrder RecordBuilder
   */
  public static com.learnavro.domain.generated.CoffeeOrder.Builder newBuilder() {
    return new com.learnavro.domain.generated.CoffeeOrder.Builder();
  }

  /**
   * Creates a new CoffeeOrder RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CoffeeOrder RecordBuilder
   */
  public static com.learnavro.domain.generated.CoffeeOrder.Builder newBuilder(com.learnavro.domain.generated.CoffeeOrder.Builder other) {
    if (other == null) {
      return new com.learnavro.domain.generated.CoffeeOrder.Builder();
    } else {
      return new com.learnavro.domain.generated.CoffeeOrder.Builder(other);
    }
  }

  /**
   * Creates a new CoffeeOrder RecordBuilder by copying an existing CoffeeOrder instance.
   * @param other The existing instance to copy.
   * @return A new CoffeeOrder RecordBuilder
   */
  public static com.learnavro.domain.generated.CoffeeOrder.Builder newBuilder(com.learnavro.domain.generated.CoffeeOrder other) {
    if (other == null) {
      return new com.learnavro.domain.generated.CoffeeOrder.Builder();
    } else {
      return new com.learnavro.domain.generated.CoffeeOrder.Builder(other);
    }
  }

  /**
   * RecordBuilder for CoffeeOrder instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CoffeeOrder>
    implements org.apache.avro.data.RecordBuilder<CoffeeOrder> {

    private java.util.UUID id;
    private java.lang.String fullName;
    /** Optional field represents the nickName of the user */
    private java.lang.String nickName;
    /** Optional field represents the nickName of the user */
    private java.lang.String nickName1;
    private com.learnavro.domain.generated.Store store;
    private com.learnavro.domain.generated.Store.Builder storeBuilder;
    private java.util.List<com.learnavro.domain.generated.OrderLineItem> orderLineItems;
    private com.learnavro.domain.generated.PickUp pick_up;
    private java.time.Instant ordered_time;
    private java.lang.String status;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.learnavro.domain.generated.CoffeeOrder.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.fullName)) {
        this.fullName = data().deepCopy(fields()[1].schema(), other.fullName);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.nickName)) {
        this.nickName = data().deepCopy(fields()[2].schema(), other.nickName);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.nickName1)) {
        this.nickName1 = data().deepCopy(fields()[3].schema(), other.nickName1);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.store)) {
        this.store = data().deepCopy(fields()[4].schema(), other.store);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (other.hasStoreBuilder()) {
        this.storeBuilder = com.learnavro.domain.generated.Store.newBuilder(other.getStoreBuilder());
      }
      if (isValidValue(fields()[5], other.orderLineItems)) {
        this.orderLineItems = data().deepCopy(fields()[5].schema(), other.orderLineItems);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.pick_up)) {
        this.pick_up = data().deepCopy(fields()[6].schema(), other.pick_up);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.ordered_time)) {
        this.ordered_time = data().deepCopy(fields()[7].schema(), other.ordered_time);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.status)) {
        this.status = data().deepCopy(fields()[8].schema(), other.status);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
    }

    /**
     * Creates a Builder by copying an existing CoffeeOrder instance
     * @param other The existing instance to copy.
     */
    private Builder(com.learnavro.domain.generated.CoffeeOrder other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.fullName)) {
        this.fullName = data().deepCopy(fields()[1].schema(), other.fullName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.nickName)) {
        this.nickName = data().deepCopy(fields()[2].schema(), other.nickName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.nickName1)) {
        this.nickName1 = data().deepCopy(fields()[3].schema(), other.nickName1);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.store)) {
        this.store = data().deepCopy(fields()[4].schema(), other.store);
        fieldSetFlags()[4] = true;
      }
      this.storeBuilder = null;
      if (isValidValue(fields()[5], other.orderLineItems)) {
        this.orderLineItems = data().deepCopy(fields()[5].schema(), other.orderLineItems);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.pick_up)) {
        this.pick_up = data().deepCopy(fields()[6].schema(), other.pick_up);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.ordered_time)) {
        this.ordered_time = data().deepCopy(fields()[7].schema(), other.ordered_time);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.status)) {
        this.status = data().deepCopy(fields()[8].schema(), other.status);
        fieldSetFlags()[8] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.util.UUID getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder setId(java.util.UUID value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'fullName' field.
      * @return The value.
      */
    public java.lang.String getFullName() {
      return fullName;
    }


    /**
      * Sets the value of the 'fullName' field.
      * @param value The value of 'fullName'.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder setFullName(java.lang.String value) {
      validate(fields()[1], value);
      this.fullName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'fullName' field has been set.
      * @return True if the 'fullName' field has been set, false otherwise.
      */
    public boolean hasFullName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'fullName' field.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder clearFullName() {
      fullName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'nickName' field.
      * Optional field represents the nickName of the user
      * @return The value.
      */
    public java.lang.String getNickName() {
      return nickName;
    }


    /**
      * Sets the value of the 'nickName' field.
      * Optional field represents the nickName of the user
      * @param value The value of 'nickName'.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder setNickName(java.lang.String value) {
      validate(fields()[2], value);
      this.nickName = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'nickName' field has been set.
      * Optional field represents the nickName of the user
      * @return True if the 'nickName' field has been set, false otherwise.
      */
    public boolean hasNickName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'nickName' field.
      * Optional field represents the nickName of the user
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder clearNickName() {
      nickName = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'nickName1' field.
      * Optional field represents the nickName of the user
      * @return The value.
      */
    public java.lang.String getNickName1() {
      return nickName1;
    }


    /**
      * Sets the value of the 'nickName1' field.
      * Optional field represents the nickName of the user
      * @param value The value of 'nickName1'.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder setNickName1(java.lang.String value) {
      validate(fields()[3], value);
      this.nickName1 = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'nickName1' field has been set.
      * Optional field represents the nickName of the user
      * @return True if the 'nickName1' field has been set, false otherwise.
      */
    public boolean hasNickName1() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'nickName1' field.
      * Optional field represents the nickName of the user
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder clearNickName1() {
      nickName1 = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'store' field.
      * @return The value.
      */
    public com.learnavro.domain.generated.Store getStore() {
      return store;
    }


    /**
      * Sets the value of the 'store' field.
      * @param value The value of 'store'.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder setStore(com.learnavro.domain.generated.Store value) {
      validate(fields()[4], value);
      this.storeBuilder = null;
      this.store = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'store' field has been set.
      * @return True if the 'store' field has been set, false otherwise.
      */
    public boolean hasStore() {
      return fieldSetFlags()[4];
    }

    /**
     * Gets the Builder instance for the 'store' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.learnavro.domain.generated.Store.Builder getStoreBuilder() {
      if (storeBuilder == null) {
        if (hasStore()) {
          setStoreBuilder(com.learnavro.domain.generated.Store.newBuilder(store));
        } else {
          setStoreBuilder(com.learnavro.domain.generated.Store.newBuilder());
        }
      }
      return storeBuilder;
    }

    /**
     * Sets the Builder instance for the 'store' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public com.learnavro.domain.generated.CoffeeOrder.Builder setStoreBuilder(com.learnavro.domain.generated.Store.Builder value) {
      clearStore();
      storeBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'store' field has an active Builder instance
     * @return True if the 'store' field has an active Builder instance
     */
    public boolean hasStoreBuilder() {
      return storeBuilder != null;
    }

    /**
      * Clears the value of the 'store' field.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder clearStore() {
      store = null;
      storeBuilder = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'orderLineItems' field.
      * @return The value.
      */
    public java.util.List<com.learnavro.domain.generated.OrderLineItem> getOrderLineItems() {
      return orderLineItems;
    }


    /**
      * Sets the value of the 'orderLineItems' field.
      * @param value The value of 'orderLineItems'.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder setOrderLineItems(java.util.List<com.learnavro.domain.generated.OrderLineItem> value) {
      validate(fields()[5], value);
      this.orderLineItems = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'orderLineItems' field has been set.
      * @return True if the 'orderLineItems' field has been set, false otherwise.
      */
    public boolean hasOrderLineItems() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'orderLineItems' field.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder clearOrderLineItems() {
      orderLineItems = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'pick_up' field.
      * @return The value.
      */
    public com.learnavro.domain.generated.PickUp getPickUp() {
      return pick_up;
    }


    /**
      * Sets the value of the 'pick_up' field.
      * @param value The value of 'pick_up'.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder setPickUp(com.learnavro.domain.generated.PickUp value) {
      validate(fields()[6], value);
      this.pick_up = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'pick_up' field has been set.
      * @return True if the 'pick_up' field has been set, false otherwise.
      */
    public boolean hasPickUp() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'pick_up' field.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder clearPickUp() {
      pick_up = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'ordered_time' field.
      * @return The value.
      */
    public java.time.Instant getOrderedTime() {
      return ordered_time;
    }


    /**
      * Sets the value of the 'ordered_time' field.
      * @param value The value of 'ordered_time'.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder setOrderedTime(java.time.Instant value) {
      validate(fields()[7], value);
      this.ordered_time = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'ordered_time' field has been set.
      * @return True if the 'ordered_time' field has been set, false otherwise.
      */
    public boolean hasOrderedTime() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'ordered_time' field.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder clearOrderedTime() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'status' field.
      * @return The value.
      */
    public java.lang.String getStatus() {
      return status;
    }


    /**
      * Sets the value of the 'status' field.
      * @param value The value of 'status'.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder setStatus(java.lang.String value) {
      validate(fields()[8], value);
      this.status = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'status' field has been set.
      * @return True if the 'status' field has been set, false otherwise.
      */
    public boolean hasStatus() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'status' field.
      * @return This builder.
      */
    public com.learnavro.domain.generated.CoffeeOrder.Builder clearStatus() {
      status = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CoffeeOrder build() {
      try {
        CoffeeOrder record = new CoffeeOrder();
        record.id = fieldSetFlags()[0] ? this.id : (java.util.UUID) defaultValue(fields()[0]);
        record.fullName = fieldSetFlags()[1] ? this.fullName : (java.lang.String) defaultValue(fields()[1]);
        record.nickName = fieldSetFlags()[2] ? this.nickName : (java.lang.String) defaultValue(fields()[2]);
        record.nickName1 = fieldSetFlags()[3] ? this.nickName1 : (java.lang.String) defaultValue(fields()[3]);
        if (storeBuilder != null) {
          try {
            record.store = this.storeBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("store"));
            throw e;
          }
        } else {
          record.store = fieldSetFlags()[4] ? this.store : (com.learnavro.domain.generated.Store) defaultValue(fields()[4]);
        }
        record.orderLineItems = fieldSetFlags()[5] ? this.orderLineItems : (java.util.List<com.learnavro.domain.generated.OrderLineItem>) defaultValue(fields()[5]);
        record.pick_up = fieldSetFlags()[6] ? this.pick_up : (com.learnavro.domain.generated.PickUp) defaultValue(fields()[6]);
        record.ordered_time = fieldSetFlags()[7] ? this.ordered_time : (java.time.Instant) defaultValue(fields()[7]);
        record.status = fieldSetFlags()[8] ? this.status : (java.lang.String) defaultValue(fields()[8]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CoffeeOrder>
    WRITER$ = (org.apache.avro.io.DatumWriter<CoffeeOrder>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CoffeeOrder>
    READER$ = (org.apache.avro.io.DatumReader<CoffeeOrder>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










