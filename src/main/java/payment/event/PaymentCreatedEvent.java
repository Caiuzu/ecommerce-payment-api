package payment.event;

import org.apache.avro.specific.SpecificData;

/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class PaymentCreatedEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    private static final long serialVersionUID = -2252098323115404215L;
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PaymentCreatedEvent\",\"namespace\":\"payment.event\",\"fields\":[{\"name\":\"checkoutCode\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"paymentCode\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"}]}]}");

    public static org.apache.avro.Schema getClassSchema() {
        return SCHEMA$;
    }

    @Deprecated
    public java.lang.Object checkoutCode;
    @Deprecated
    public java.lang.Object paymentCode;

    /**
     * Default constructor.  Note that this does not initialize fields
     * to their default values from the schema.  If that is desired then
     * one should use <code>newBuilder()</code>.
     */
    public PaymentCreatedEvent() {
    }

    /**
     * All-args constructor.
     *
     * @param checkoutCode The new value for checkoutCode
     * @param paymentCode  The new value for paymentCode
     */
    public PaymentCreatedEvent(java.lang.Object checkoutCode, java.lang.Object paymentCode) {
        this.checkoutCode = checkoutCode;
        this.paymentCode = paymentCode;
    }

    public org.apache.avro.Schema getSchema() {
        return SCHEMA$;
    }

    // Used by DatumWriter.  Applications should not call.
    public java.lang.Object get(int field$) {
        switch (field$) {
            case 0:
                return checkoutCode;
            case 1:
                return paymentCode;
            default:
                throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    // Used by DatumReader.  Applications should not call.
    @SuppressWarnings(value = "unchecked")
    public void put(int field$, java.lang.Object value$) {
        switch (field$) {
            case 0:
                checkoutCode = (java.lang.Object) value$;
                break;
            case 1:
                paymentCode = (java.lang.Object) value$;
                break;
            default:
                throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    /**
     * Gets the value of the 'checkoutCode' field.
     *
     * @return The value of the 'checkoutCode' field.
     */
    public java.lang.Object getCheckoutCode() {
        return checkoutCode;
    }

    /**
     * Sets the value of the 'checkoutCode' field.
     *
     * @param value the value to set.
     */
    public void setCheckoutCode(java.lang.Object value) {
        this.checkoutCode = value;
    }

    /**
     * Gets the value of the 'paymentCode' field.
     *
     * @return The value of the 'paymentCode' field.
     */
    public java.lang.Object getPaymentCode() {
        return paymentCode;
    }

    /**
     * Sets the value of the 'paymentCode' field.
     *
     * @param value the value to set.
     */
    public void setPaymentCode(java.lang.Object value) {
        this.paymentCode = value;
    }

    /**
     * Creates a new PaymentCreatedEvent RecordBuilder.
     *
     * @return A new PaymentCreatedEvent RecordBuilder
     */
    public static payment.event.PaymentCreatedEvent.Builder newBuilder() {
        return new payment.event.PaymentCreatedEvent.Builder();
    }

    /**
     * Creates a new PaymentCreatedEvent RecordBuilder by copying an existing Builder.
     *
     * @param other The existing builder to copy.
     * @return A new PaymentCreatedEvent RecordBuilder
     */
    public static payment.event.PaymentCreatedEvent.Builder newBuilder(payment.event.PaymentCreatedEvent.Builder other) {
        return new payment.event.PaymentCreatedEvent.Builder(other);
    }

    /**
     * Creates a new PaymentCreatedEvent RecordBuilder by copying an existing PaymentCreatedEvent instance.
     *
     * @param other The existing instance to copy.
     * @return A new PaymentCreatedEvent RecordBuilder
     */
    public static payment.event.PaymentCreatedEvent.Builder newBuilder(payment.event.PaymentCreatedEvent other) {
        return new payment.event.PaymentCreatedEvent.Builder(other);
    }

    /**
     * RecordBuilder for PaymentCreatedEvent instances.
     */
    public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PaymentCreatedEvent>
            implements org.apache.avro.data.RecordBuilder<PaymentCreatedEvent> {

        private java.lang.Object checkoutCode;
        private java.lang.Object paymentCode;

        /**
         * Creates a new Builder
         */
        private Builder() {
            super(SCHEMA$);
        }

        /**
         * Creates a Builder by copying an existing Builder.
         *
         * @param other The existing Builder to copy.
         */
        private Builder(payment.event.PaymentCreatedEvent.Builder other) {
            super(other);
            if (isValidValue(fields()[0], other.checkoutCode)) {
                this.checkoutCode = data().deepCopy(fields()[0].schema(), other.checkoutCode);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.paymentCode)) {
                this.paymentCode = data().deepCopy(fields()[1].schema(), other.paymentCode);
                fieldSetFlags()[1] = true;
            }
        }

        /**
         * Creates a Builder by copying an existing PaymentCreatedEvent instance
         *
         * @param other The existing instance to copy.
         */
        private Builder(payment.event.PaymentCreatedEvent other) {
            super(SCHEMA$);
            if (isValidValue(fields()[0], other.checkoutCode)) {
                this.checkoutCode = data().deepCopy(fields()[0].schema(), other.checkoutCode);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.paymentCode)) {
                this.paymentCode = data().deepCopy(fields()[1].schema(), other.paymentCode);
                fieldSetFlags()[1] = true;
            }
        }

        /**
         * Gets the value of the 'checkoutCode' field.
         *
         * @return The value.
         */
        public java.lang.Object getCheckoutCode() {
            return checkoutCode;
        }

        /**
         * Sets the value of the 'checkoutCode' field.
         *
         * @param value The value of 'checkoutCode'.
         * @return This builder.
         */
        public payment.event.PaymentCreatedEvent.Builder setCheckoutCode(java.lang.Object value) {
            validate(fields()[0], value);
            this.checkoutCode = value;
            fieldSetFlags()[0] = true;
            return this;
        }

        /**
         * Checks whether the 'checkoutCode' field has been set.
         *
         * @return True if the 'checkoutCode' field has been set, false otherwise.
         */
        public boolean hasCheckoutCode() {
            return fieldSetFlags()[0];
        }


        /**
         * Clears the value of the 'checkoutCode' field.
         *
         * @return This builder.
         */
        public payment.event.PaymentCreatedEvent.Builder clearCheckoutCode() {
            checkoutCode = null;
            fieldSetFlags()[0] = false;
            return this;
        }

        /**
         * Gets the value of the 'paymentCode' field.
         *
         * @return The value.
         */
        public java.lang.Object getPaymentCode() {
            return paymentCode;
        }

        /**
         * Sets the value of the 'paymentCode' field.
         *
         * @param value The value of 'paymentCode'.
         * @return This builder.
         */
        public payment.event.PaymentCreatedEvent.Builder setPaymentCode(java.lang.Object value) {
            validate(fields()[1], value);
            this.paymentCode = value;
            fieldSetFlags()[1] = true;
            return this;
        }

        /**
         * Checks whether the 'paymentCode' field has been set.
         *
         * @return True if the 'paymentCode' field has been set, false otherwise.
         */
        public boolean hasPaymentCode() {
            return fieldSetFlags()[1];
        }


        /**
         * Clears the value of the 'paymentCode' field.
         *
         * @return This builder.
         */
        public payment.event.PaymentCreatedEvent.Builder clearPaymentCode() {
            paymentCode = null;
            fieldSetFlags()[1] = false;
            return this;
        }

        @Override
        public PaymentCreatedEvent build() {
            try {
                PaymentCreatedEvent record = new PaymentCreatedEvent();
                record.checkoutCode = fieldSetFlags()[0] ? this.checkoutCode : (java.lang.Object) defaultValue(fields()[0]);
                record.paymentCode = fieldSetFlags()[1] ? this.paymentCode : (java.lang.Object) defaultValue(fields()[1]);
                return record;
            } catch (Exception e) {
                throw new org.apache.avro.AvroRuntimeException(e);
            }
        }
    }

    private static final org.apache.avro.io.DatumWriter
            WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

    @Override
    public void writeExternal(java.io.ObjectOutput out)
            throws java.io.IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    private static final org.apache.avro.io.DatumReader
            READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

    @Override
    public void readExternal(java.io.ObjectInput in)
            throws java.io.IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

}
