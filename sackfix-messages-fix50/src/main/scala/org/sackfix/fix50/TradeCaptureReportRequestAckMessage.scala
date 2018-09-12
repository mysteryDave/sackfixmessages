package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class TradeCaptureReportRequestAckMessage(tradeRequestIDField:TradeRequestIDField,
                                               tradeRequestTypeField:TradeRequestTypeField,
                                               subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None,
                                               totNumTradeReportsField:Option[TotNumTradeReportsField]=None,
                                               tradeRequestResultField:TradeRequestResultField,
                                               tradeRequestStatusField:TradeRequestStatusField,
                                               instrumentComponent:InstrumentComponent,
                                               undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                               instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                               multiLegReportingTypeField:Option[MultiLegReportingTypeField]=None,
                                               responseTransportTypeField:Option[ResponseTransportTypeField]=None,
                                               responseDestinationField:Option[ResponseDestinationField]=None,
                                               textField:Option[TextField]=None,
                                               encodedTextLenField:Option[EncodedTextLenField]=None,
                                               encodedTextField:Option[EncodedTextField]=None,
                                               messageEventSourceField:Option[MessageEventSourceField]=None,
                                               tradeIDField:Option[TradeIDField]=None,
                                               secondaryTradeIDField:Option[SecondaryTradeIDField]=None,
                                               firmTradeIDField:Option[FirmTradeIDField]=None,
                                               secondaryFirmTradeIDField:Option[SecondaryFirmTradeIDField]=None) extends SfFixMessageBody("AQ")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,tradeRequestIDField)
    fmt(b,tradeRequestTypeField)
    subscriptionRequestTypeField.foreach(fmt(b,_))
    totNumTradeReportsField.foreach(fmt(b,_))
    fmt(b,tradeRequestResultField)
    fmt(b,tradeRequestStatusField)
    fmt(b,instrumentComponent)
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    multiLegReportingTypeField.foreach(fmt(b,_))
    responseTransportTypeField.foreach(fmt(b,_))
    responseDestinationField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    messageEventSourceField.foreach(fmt(b,_))
    tradeIDField.foreach(fmt(b,_))
    secondaryTradeIDField.foreach(fmt(b,_))
    firmTradeIDField.foreach(fmt(b,_))
    secondaryFirmTradeIDField.foreach(fmt(b,_))
    b
  }

}
     
object TradeCaptureReportRequestAckMessage extends SfFixMessageDecoder {
  val MsgType="AQ"
  val MsgName="TradeCaptureReportRequestAck"
             
  override val MandatoryFields = HashSet[Int](
    TradeRequestIDField.TagId, TradeRequestTypeField.TagId, TradeRequestResultField.TagId, TradeRequestStatusField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SubscriptionRequestTypeField.TagId, TotNumTradeReportsField.TagId, MultiLegReportingTypeField.TagId, ResponseTransportTypeField.TagId, ResponseDestinationField.TagId, 
    TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, MessageEventSourceField.TagId, TradeIDField.TagId, 
    SecondaryTradeIDField.TagId, FirmTradeIDField.TagId, SecondaryFirmTradeIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==TradeRequestIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(TradeCaptureReportRequestAckMessage(TradeRequestIDField.decode(myFields.get(TradeRequestIDField.TagId)).get,
        TradeRequestTypeField.decode(myFields.get(TradeRequestTypeField.TagId)).get,
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f)),
        myFields.get(TotNumTradeReportsField.TagId).flatMap(f=>TotNumTradeReportsField.decode(f)),
        TradeRequestResultField.decode(myFields.get(TradeRequestResultField.TagId)).get,
        TradeRequestStatusField.decode(myFields.get(TradeRequestStatusField.TagId)).get,
        InstrumentComponent.decode(flds, startPos).get,
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        myFields.get(MultiLegReportingTypeField.TagId).flatMap(f=>MultiLegReportingTypeField.decode(f)),
        myFields.get(ResponseTransportTypeField.TagId).flatMap(f=>ResponseTransportTypeField.decode(f)),
        myFields.get(ResponseDestinationField.TagId).flatMap(f=>ResponseDestinationField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(MessageEventSourceField.TagId).flatMap(f=>MessageEventSourceField.decode(f)),
        myFields.get(TradeIDField.TagId).flatMap(f=>TradeIDField.decode(f)),
        myFields.get(SecondaryTradeIDField.TagId).flatMap(f=>SecondaryTradeIDField.decode(f)),
        myFields.get(FirmTradeIDField.TagId).flatMap(f=>FirmTradeIDField.decode(f)),
        myFields.get(SecondaryFirmTradeIDField.TagId).flatMap(f=>SecondaryFirmTradeIDField.decode(f))))
    } else None
  }

    
}
     