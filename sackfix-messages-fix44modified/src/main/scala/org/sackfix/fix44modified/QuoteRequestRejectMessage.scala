package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class QuoteRequestRejectMessage(quoteReqIDField:QuoteReqIDField,
                                     rFQReqIDField:Option[RFQReqIDField]=None,
                                     quoteRequestRejectReasonField:QuoteRequestRejectReasonField,
                                     noRelatedSymField:NoRelatedSymField,
                                     relatedSymGroups: List[RelatedSymGroup],
                                     noQuoteQualifiersField:Option[NoQuoteQualifiersField]=None,
                                     quoteQualifiersGroups: Option[List[QuoteQualifiersGroup]]=None,
                                     quotePriceTypeField:Option[QuotePriceTypeField]=None,
                                     ordTypeField:Option[OrdTypeField]=None,
                                     expireTimeField:Option[ExpireTimeField]=None,
                                     transactTimeField:Option[TransactTimeField]=None,
                                     spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                     priceTypeField:Option[PriceTypeField]=None,
                                     priceField:Option[PriceField]=None,
                                     price2Field:Option[Price2Field]=None,
                                     yieldDataComponent:Option[YieldDataComponent]=None,
                                     partiesComponent:Option[PartiesComponent]=None,
                                     textField:Option[TextField]=None,
                                     encodedTextLenField:Option[EncodedTextLenField]=None,
                                     encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AG")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noRelatedSymField.value != relatedSymGroups.size)
    throw SfRepeatingGroupCountException(NoRelatedSymField.TagId,noRelatedSymField.value, relatedSymGroups.size)
  if (noQuoteQualifiersField.map(_.value).getOrElse(0) != quoteQualifiersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoQuoteQualifiersField.TagId,noQuoteQualifiersField.map(_.value).getOrElse(0), quoteQualifiersGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,quoteReqIDField)
    rFQReqIDField.foreach(fmt(b,_))
    fmt(b,quoteRequestRejectReasonField)
    fmt(b,noRelatedSymField)
    noQuoteQualifiersField.foreach(fmt(b,_))
    quoteQualifiersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    quotePriceTypeField.foreach(fmt(b,_))
    ordTypeField.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    price2Field.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object QuoteRequestRejectMessage extends SfFixMessageDecoder {
  val MsgType="AG"
  val MsgName="QuoteRequestReject"
             
  override val MandatoryFields = HashSet[Int](
    QuoteReqIDField.TagId, QuoteRequestRejectReasonField.TagId, NoRelatedSymField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RelatedSymGroup.isMandatoryField(tagId) || QuoteQualifiersGroup.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId) || 
    PartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    RFQReqIDField.TagId, NoQuoteQualifiersField.TagId, QuotePriceTypeField.TagId, OrdTypeField.TagId, ExpireTimeField.TagId, 
    TransactTimeField.TagId, PriceTypeField.TagId, PriceField.TagId, Price2Field.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RelatedSymGroup.isOptionalField(tagId) || QuoteQualifiersGroup.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId) || 
    PartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RelatedSymGroup.isFieldOf(tagId) || QuoteQualifiersGroup.isFieldOf(tagId) || SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || 
    YieldDataComponent.isFieldOf(tagId) || PartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoRelatedSymField.TagId, NoQuoteQualifiersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(QuoteRequestRejectMessage(QuoteReqIDField.decode(myFields.get(QuoteReqIDField.TagId)).get,
        myFields.get(RFQReqIDField.TagId).flatMap(f=>RFQReqIDField.decode(f)),
        QuoteRequestRejectReasonField.decode(myFields.get(QuoteRequestRejectReasonField.TagId)).get,
        NoRelatedSymField.decode(myFields.get(NoRelatedSymField.TagId)).get,
        if (nextTagPosLookup.contains(NoRelatedSymField.TagId)) RelatedSymGroup.decode(flds, nextTagPosLookup(NoRelatedSymField.TagId)).get else List.empty,
        myFields.get(NoQuoteQualifiersField.TagId).flatMap(f=>NoQuoteQualifiersField.decode(f)),
        if (nextTagPosLookup.contains(NoQuoteQualifiersField.TagId)) QuoteQualifiersGroup.decode(flds, nextTagPosLookup(NoQuoteQualifiersField.TagId)) else None,
        myFields.get(QuotePriceTypeField.TagId).flatMap(f=>QuotePriceTypeField.decode(f)),
        myFields.get(OrdTypeField.TagId).flatMap(f=>OrdTypeField.decode(f)),
        myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(Price2Field.TagId).flatMap(f=>Price2Field.decode(f)),
        YieldDataComponent.decode(flds, startPos),
        PartiesComponent.decode(flds, startPos),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     