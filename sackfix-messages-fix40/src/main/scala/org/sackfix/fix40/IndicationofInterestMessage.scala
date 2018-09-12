package org.sackfix.fix40

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX40.xml
  */
case class IndicationofInterestMessage(iOIIDIntField:IOIIDIntField,
                                       iOITransTypeField:IOITransTypeField,
                                       iOIRefIDIntField:Option[IOIRefIDIntField]=None,
                                       symbolField:SymbolField,
                                       symbolSfxField:Option[SymbolSfxField]=None,
                                       securityIDField:Option[SecurityIDField]=None,
                                       iDSourceField:Option[IDSourceField]=None,
                                       issuerField:Option[IssuerField]=None,
                                       securityDescField:Option[SecurityDescField]=None,
                                       sideField:SideField,
                                       iOISharesField:IOISharesField,
                                       priceField:Option[PriceField]=None,
                                       currencyField:Option[CurrencyField]=None,
                                       validUntilTimeField:Option[ValidUntilTimeField]=None,
                                       iOIQltyIndField:Option[IOIQltyIndField]=None,
                                       iOIOthSvcField:Option[IOIOthSvcField]=None,
                                       iOINaturalFlagStringField:Option[IOINaturalFlagStringField]=None,
                                       iOIQualifierField:Option[IOIQualifierField]=None,
                                       textField:Option[TextField]=None) extends SfFixMessageBody("6")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,iOIIDIntField)
    fmt(b,iOITransTypeField)
    iOIRefIDIntField.foreach(fmt(b,_))
    fmt(b,symbolField)
    symbolSfxField.foreach(fmt(b,_))
    securityIDField.foreach(fmt(b,_))
    iDSourceField.foreach(fmt(b,_))
    issuerField.foreach(fmt(b,_))
    securityDescField.foreach(fmt(b,_))
    fmt(b,sideField)
    fmt(b,iOISharesField)
    priceField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    validUntilTimeField.foreach(fmt(b,_))
    iOIQltyIndField.foreach(fmt(b,_))
    iOIOthSvcField.foreach(fmt(b,_))
    iOINaturalFlagStringField.foreach(fmt(b,_))
    iOIQualifierField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    b
  }

}
     
object IndicationofInterestMessage extends SfFixMessageDecoder {
  val MsgType="6"
  val MsgName="IndicationofInterest"
             
  override val MandatoryFields = HashSet[Int](
    IOIIDIntField.TagId, IOITransTypeField.TagId, SymbolField.TagId, SideField.TagId, IOISharesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    IOIRefIDIntField.TagId, SymbolSfxField.TagId, SecurityIDField.TagId, IDSourceField.TagId, IssuerField.TagId, 
    SecurityDescField.TagId, PriceField.TagId, CurrencyField.TagId, ValidUntilTimeField.TagId, IOIQltyIndField.TagId, 
    IOIOthSvcField.TagId, IOINaturalFlagStringField.TagId, IOIQualifierField.TagId, TextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==IOIIDIntField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(IndicationofInterestMessage(IOIIDIntField.decode(myFields.get(IOIIDIntField.TagId)).get,
        IOITransTypeField.decode(myFields.get(IOITransTypeField.TagId)).get,
        myFields.get(IOIRefIDIntField.TagId).flatMap(f=>IOIRefIDIntField.decode(f)),
        SymbolField.decode(myFields.get(SymbolField.TagId)).get,
        myFields.get(SymbolSfxField.TagId).flatMap(f=>SymbolSfxField.decode(f)),
        myFields.get(SecurityIDField.TagId).flatMap(f=>SecurityIDField.decode(f)),
        myFields.get(IDSourceField.TagId).flatMap(f=>IDSourceField.decode(f)),
        myFields.get(IssuerField.TagId).flatMap(f=>IssuerField.decode(f)),
        myFields.get(SecurityDescField.TagId).flatMap(f=>SecurityDescField.decode(f)),
        SideField.decode(myFields.get(SideField.TagId)).get,
        IOISharesField.decode(myFields.get(IOISharesField.TagId)).get,
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(ValidUntilTimeField.TagId).flatMap(f=>ValidUntilTimeField.decode(f)),
        myFields.get(IOIQltyIndField.TagId).flatMap(f=>IOIQltyIndField.decode(f)),
        myFields.get(IOIOthSvcField.TagId).flatMap(f=>IOIOthSvcField.decode(f)),
        myFields.get(IOINaturalFlagStringField.TagId).flatMap(f=>IOINaturalFlagStringField.decode(f)),
        myFields.get(IOIQualifierField.TagId).flatMap(f=>IOIQualifierField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f))))
    } else None
  }

    
}
     