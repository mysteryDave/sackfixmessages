package org.sackfix.fix41

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX41.xml
  */
case class QuoteMessage(quoteReqIDField:Option[QuoteReqIDField]=None,
                        quoteIDField:QuoteIDField,
                        symbolField:SymbolField,
                        symbolSfxField:Option[SymbolSfxField]=None,
                        securityIDField:Option[SecurityIDField]=None,
                        iDSourceField:Option[IDSourceField]=None,
                        securityTypeField:Option[SecurityTypeField]=None,
                        maturityMonthYearField:Option[MaturityMonthYearField]=None,
                        maturityDayField:Option[MaturityDayField]=None,
                        putOrCallField:Option[PutOrCallField]=None,
                        strikePriceField:Option[StrikePriceField]=None,
                        optAttributeField:Option[OptAttributeField]=None,
                        securityExchangeField:Option[SecurityExchangeField]=None,
                        issuerField:Option[IssuerField]=None,
                        securityDescField:Option[SecurityDescField]=None,
                        bidPxField:Option[BidPxField]=None,
                        offerPxField:Option[OfferPxField]=None,
                        bidSizeIntField:Option[BidSizeIntField]=None,
                        offerSizeIntField:Option[OfferSizeIntField]=None,
                        validUntilTimeField:Option[ValidUntilTimeField]=None,
                        bidSpotRateField:Option[BidSpotRateField]=None,
                        offerSpotRateField:Option[OfferSpotRateField]=None,
                        bidForwardPointsField:Option[BidForwardPointsField]=None,
                        offerForwardPointsField:Option[OfferForwardPointsField]=None,
                        transactTimeField:Option[TransactTimeField]=None,
                        futSettDateField:Option[FutSettDateField]=None,
                        ordTypeField:Option[OrdTypeField]=None,
                        futSettDate2Field:Option[FutSettDate2Field]=None,
                        orderQty2Field:Option[OrderQty2Field]=None) extends SfFixMessageBody("S")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    quoteReqIDField.foreach(fmt(b,_))
    fmt(b,quoteIDField)
    fmt(b,symbolField)
    symbolSfxField.foreach(fmt(b,_))
    securityIDField.foreach(fmt(b,_))
    iDSourceField.foreach(fmt(b,_))
    securityTypeField.foreach(fmt(b,_))
    maturityMonthYearField.foreach(fmt(b,_))
    maturityDayField.foreach(fmt(b,_))
    putOrCallField.foreach(fmt(b,_))
    strikePriceField.foreach(fmt(b,_))
    optAttributeField.foreach(fmt(b,_))
    securityExchangeField.foreach(fmt(b,_))
    issuerField.foreach(fmt(b,_))
    securityDescField.foreach(fmt(b,_))
    bidPxField.foreach(fmt(b,_))
    offerPxField.foreach(fmt(b,_))
    bidSizeIntField.foreach(fmt(b,_))
    offerSizeIntField.foreach(fmt(b,_))
    validUntilTimeField.foreach(fmt(b,_))
    bidSpotRateField.foreach(fmt(b,_))
    offerSpotRateField.foreach(fmt(b,_))
    bidForwardPointsField.foreach(fmt(b,_))
    offerForwardPointsField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    futSettDateField.foreach(fmt(b,_))
    ordTypeField.foreach(fmt(b,_))
    futSettDate2Field.foreach(fmt(b,_))
    orderQty2Field.foreach(fmt(b,_))
    b
  }

}
     
object QuoteMessage extends SfFixMessageDecoder {
  val MsgType="S"
  val MsgName="Quote"
             
  override val MandatoryFields = HashSet[Int](
    QuoteIDField.TagId, SymbolField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    QuoteReqIDField.TagId, SymbolSfxField.TagId, SecurityIDField.TagId, IDSourceField.TagId, SecurityTypeField.TagId, 
    MaturityMonthYearField.TagId, MaturityDayField.TagId, PutOrCallField.TagId, StrikePriceField.TagId, OptAttributeField.TagId, 
    SecurityExchangeField.TagId, IssuerField.TagId, SecurityDescField.TagId, BidPxField.TagId, OfferPxField.TagId, 
    BidSizeIntField.TagId, OfferSizeIntField.TagId, ValidUntilTimeField.TagId, BidSpotRateField.TagId, OfferSpotRateField.TagId, 
    BidForwardPointsField.TagId, OfferForwardPointsField.TagId, TransactTimeField.TagId, FutSettDateField.TagId, OrdTypeField.TagId, 
    FutSettDate2Field.TagId, OrderQty2Field.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(QuoteMessage(myFields.get(QuoteReqIDField.TagId).flatMap(f=>QuoteReqIDField.decode(f)),
        QuoteIDField.decode(myFields.get(QuoteIDField.TagId)).get,
        SymbolField.decode(myFields.get(SymbolField.TagId)).get,
        myFields.get(SymbolSfxField.TagId).flatMap(f=>SymbolSfxField.decode(f)),
        myFields.get(SecurityIDField.TagId).flatMap(f=>SecurityIDField.decode(f)),
        myFields.get(IDSourceField.TagId).flatMap(f=>IDSourceField.decode(f)),
        myFields.get(SecurityTypeField.TagId).flatMap(f=>SecurityTypeField.decode(f)),
        myFields.get(MaturityMonthYearField.TagId).flatMap(f=>MaturityMonthYearField.decode(f)),
        myFields.get(MaturityDayField.TagId).flatMap(f=>MaturityDayField.decode(f)),
        myFields.get(PutOrCallField.TagId).flatMap(f=>PutOrCallField.decode(f)),
        myFields.get(StrikePriceField.TagId).flatMap(f=>StrikePriceField.decode(f)),
        myFields.get(OptAttributeField.TagId).flatMap(f=>OptAttributeField.decode(f)),
        myFields.get(SecurityExchangeField.TagId).flatMap(f=>SecurityExchangeField.decode(f)),
        myFields.get(IssuerField.TagId).flatMap(f=>IssuerField.decode(f)),
        myFields.get(SecurityDescField.TagId).flatMap(f=>SecurityDescField.decode(f)),
        myFields.get(BidPxField.TagId).flatMap(f=>BidPxField.decode(f)),
        myFields.get(OfferPxField.TagId).flatMap(f=>OfferPxField.decode(f)),
        myFields.get(BidSizeIntField.TagId).flatMap(f=>BidSizeIntField.decode(f)),
        myFields.get(OfferSizeIntField.TagId).flatMap(f=>OfferSizeIntField.decode(f)),
        myFields.get(ValidUntilTimeField.TagId).flatMap(f=>ValidUntilTimeField.decode(f)),
        myFields.get(BidSpotRateField.TagId).flatMap(f=>BidSpotRateField.decode(f)),
        myFields.get(OfferSpotRateField.TagId).flatMap(f=>OfferSpotRateField.decode(f)),
        myFields.get(BidForwardPointsField.TagId).flatMap(f=>BidForwardPointsField.decode(f)),
        myFields.get(OfferForwardPointsField.TagId).flatMap(f=>OfferForwardPointsField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(FutSettDateField.TagId).flatMap(f=>FutSettDateField.decode(f)),
        myFields.get(OrdTypeField.TagId).flatMap(f=>OrdTypeField.decode(f)),
        myFields.get(FutSettDate2Field.TagId).flatMap(f=>FutSettDate2Field.decode(f)),
        myFields.get(OrderQty2Field.TagId).flatMap(f=>OrderQty2Field.decode(f))))
    } else None
  }

    
}
     