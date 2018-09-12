package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class IndicationOfInterestMessage(iOIIDField:IOIIDField,
                                       iOITransTypeField:IOITransTypeField,
                                       iOIRefIDField:Option[IOIRefIDField]=None,
                                       instrumentComponent:InstrumentComponent,
                                       financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                       noUnderlyingsField:Option[NoUnderlyingsField]=None,
                                       underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                                       sideField:SideField,
                                       qtyTypeField:Option[QtyTypeField]=None,
                                       orderQtyDataComponent:Option[OrderQtyDataComponent]=None,
                                       iOIQtyField:IOIQtyField,
                                       currencyField:Option[CurrencyField]=None,
                                       stipulationsComponent:Option[StipulationsComponent]=None,
                                       noLegsField:Option[NoLegsField]=None,
                                       legsGroups: Option[List[LegsGroup]]=None,
                                       priceTypeField:Option[PriceTypeField]=None,
                                       priceField:Option[PriceField]=None,
                                       validUntilTimeField:Option[ValidUntilTimeField]=None,
                                       iOIQltyIndField:Option[IOIQltyIndField]=None,
                                       iOINaturalFlagField:Option[IOINaturalFlagField]=None,
                                       noIOIQualifiersField:Option[NoIOIQualifiersField]=None,
                                       iOIQualifiersGroups: Option[List[IOIQualifiersGroup]]=None,
                                       textField:Option[TextField]=None,
                                       encodedTextLenField:Option[EncodedTextLenField]=None,
                                       encodedTextField:Option[EncodedTextField]=None,
                                       transactTimeField:Option[TransactTimeField]=None,
                                       uRLLinkField:Option[URLLinkField]=None,
                                       noRoutingIDsField:Option[NoRoutingIDsField]=None,
                                       routingIDsGroups: Option[List[RoutingIDsGroup]]=None,
                                       spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                       yieldDataComponent:Option[YieldDataComponent]=None) extends SfFixMessageBody("6")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))
  if (noIOIQualifiersField.map(_.value).getOrElse(0) != iOIQualifiersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoIOIQualifiersField.TagId,noIOIQualifiersField.map(_.value).getOrElse(0), iOIQualifiersGroups.map(_.size).getOrElse(0))
  if (noRoutingIDsField.map(_.value).getOrElse(0) != routingIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoRoutingIDsField.TagId,noRoutingIDsField.map(_.value).getOrElse(0), routingIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,iOIIDField)
    fmt(b,iOITransTypeField)
    iOIRefIDField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    financingDetailsComponent.foreach(fmt(b,_))
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    fmt(b,sideField)
    qtyTypeField.foreach(fmt(b,_))
    orderQtyDataComponent.foreach(fmt(b,_))
    fmt(b,iOIQtyField)
    currencyField.foreach(fmt(b,_))
    stipulationsComponent.foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    validUntilTimeField.foreach(fmt(b,_))
    iOIQltyIndField.foreach(fmt(b,_))
    iOINaturalFlagField.foreach(fmt(b,_))
    noIOIQualifiersField.foreach(fmt(b,_))
    iOIQualifiersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    uRLLinkField.foreach(fmt(b,_))
    noRoutingIDsField.foreach(fmt(b,_))
    routingIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    b
  }

}
     
object IndicationOfInterestMessage extends SfFixMessageDecoder {
  val MsgType="6"
  val MsgName="IndicationOfInterest"
             
  override val MandatoryFields = HashSet[Int](
    IOIIDField.TagId, IOITransTypeField.TagId, SideField.TagId, IOIQtyField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId) || OrderQtyDataComponent.isMandatoryField(tagId) || 
    StipulationsComponent.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId) || IOIQualifiersGroup.isMandatoryField(tagId) || RoutingIDsGroup.isMandatoryField(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    IOIRefIDField.TagId, NoUnderlyingsField.TagId, QtyTypeField.TagId, CurrencyField.TagId, NoLegsField.TagId, 
    PriceTypeField.TagId, PriceField.TagId, ValidUntilTimeField.TagId, IOIQltyIndField.TagId, IOINaturalFlagField.TagId, 
    NoIOIQualifiersField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, TransactTimeField.TagId, 
    URLLinkField.TagId, NoRoutingIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId) || OrderQtyDataComponent.isOptionalField(tagId) || 
    StipulationsComponent.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId) || IOIQualifiersGroup.isOptionalField(tagId) || RoutingIDsGroup.isOptionalField(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || UnderlyingsGroup.isFieldOf(tagId) || 
    OrderQtyDataComponent.isFieldOf(tagId) || StipulationsComponent.isFieldOf(tagId) || LegsGroup.isFieldOf(tagId) || 
    IOIQualifiersGroup.isFieldOf(tagId) || RoutingIDsGroup.isFieldOf(tagId) || SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || 
    YieldDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUnderlyingsField.TagId, NoLegsField.TagId, NoIOIQualifiersField.TagId, NoRoutingIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==IOIIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(IndicationOfInterestMessage(IOIIDField.decode(myFields.get(IOIIDField.TagId)).get,
        IOITransTypeField.decode(myFields.get(IOITransTypeField.TagId)).get,
        myFields.get(IOIRefIDField.TagId).flatMap(f=>IOIRefIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        FinancingDetailsComponent.decode(flds, startPos),
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
        SideField.decode(myFields.get(SideField.TagId)).get,
        myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
        OrderQtyDataComponent.decode(flds, startPos),
        IOIQtyField.decode(myFields.get(IOIQtyField.TagId)).get,
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        StipulationsComponent.decode(flds, startPos),
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(ValidUntilTimeField.TagId).flatMap(f=>ValidUntilTimeField.decode(f)),
        myFields.get(IOIQltyIndField.TagId).flatMap(f=>IOIQltyIndField.decode(f)),
        myFields.get(IOINaturalFlagField.TagId).flatMap(f=>IOINaturalFlagField.decode(f)),
        myFields.get(NoIOIQualifiersField.TagId).flatMap(f=>NoIOIQualifiersField.decode(f)),
        if (nextTagPosLookup.contains(NoIOIQualifiersField.TagId)) IOIQualifiersGroup.decode(flds, nextTagPosLookup(NoIOIQualifiersField.TagId)) else None,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(URLLinkField.TagId).flatMap(f=>URLLinkField.decode(f)),
        myFields.get(NoRoutingIDsField.TagId).flatMap(f=>NoRoutingIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoRoutingIDsField.TagId)) RoutingIDsGroup.decode(flds, nextTagPosLookup(NoRoutingIDsField.TagId)) else None,
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        YieldDataComponent.decode(flds, startPos)))
    } else None
  }

    
}
     