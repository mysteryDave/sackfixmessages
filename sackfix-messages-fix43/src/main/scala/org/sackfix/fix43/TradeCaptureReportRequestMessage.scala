package org.sackfix.fix43

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
  */
case class TradeCaptureReportRequestMessage(tradeRequestIDField:TradeRequestIDField,
                                            tradeRequestTypeField:TradeRequestTypeField,
                                            subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None,
                                            execIDField:Option[ExecIDField]=None,
                                            orderIDField:Option[OrderIDField]=None,
                                            clOrdIDField:Option[ClOrdIDField]=None,
                                            matchStatusField:Option[MatchStatusField]=None,
                                            partiesComponent:Option[PartiesComponent]=None,
                                            instrumentComponent:Option[InstrumentComponent]=None,
                                            noDatesField:Option[NoDatesField]=None,
                                            datesGroups: Option[List[DatesGroup]]=None,
                                            sideField:Option[SideField]=None,
                                            textField:Option[TextField]=None,
                                            encodedTextLenField:Option[EncodedTextLenField]=None,
                                            encodedTextField:Option[EncodedTextField]=None,
                                            tradeInputSourceField:Option[TradeInputSourceField]=None,
                                            tradeInputDeviceField:Option[TradeInputDeviceField]=None) extends SfFixMessageBody("AD")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noDatesField.map(_.value).getOrElse(0) != datesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoDatesField.TagId,noDatesField.map(_.value).getOrElse(0), datesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,tradeRequestIDField)
    fmt(b,tradeRequestTypeField)
    subscriptionRequestTypeField.foreach(fmt(b,_))
    execIDField.foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    matchStatusField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    noDatesField.foreach(fmt(b,_))
    datesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    tradeInputSourceField.foreach(fmt(b,_))
    tradeInputDeviceField.foreach(fmt(b,_))
    b
  }

}
     
object TradeCaptureReportRequestMessage extends SfFixMessageDecoder {
  val MsgType="AD"
  val MsgName="TradeCaptureReportRequest"
             
  override val MandatoryFields = HashSet[Int](
    TradeRequestIDField.TagId, TradeRequestTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || DatesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SubscriptionRequestTypeField.TagId, ExecIDField.TagId, OrderIDField.TagId, ClOrdIDField.TagId, MatchStatusField.TagId, 
    NoDatesField.TagId, SideField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, 
    TradeInputSourceField.TagId, TradeInputDeviceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || DatesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || DatesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoDatesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==TradeRequestIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(TradeCaptureReportRequestMessage(TradeRequestIDField.decode(myFields.get(TradeRequestIDField.TagId)).get,
        TradeRequestTypeField.decode(myFields.get(TradeRequestTypeField.TagId)).get,
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f)),
        myFields.get(ExecIDField.TagId).flatMap(f=>ExecIDField.decode(f)),
        myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(MatchStatusField.TagId).flatMap(f=>MatchStatusField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        InstrumentComponent.decode(flds, startPos),
        myFields.get(NoDatesField.TagId).flatMap(f=>NoDatesField.decode(f)),
        if (nextTagPosLookup.contains(NoDatesField.TagId)) DatesGroup.decode(flds, nextTagPosLookup(NoDatesField.TagId)) else None,
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(TradeInputSourceField.TagId).flatMap(f=>TradeInputSourceField.decode(f)),
        myFields.get(TradeInputDeviceField.TagId).flatMap(f=>TradeInputDeviceField.decode(f))))
    } else None
  }

    
}
     