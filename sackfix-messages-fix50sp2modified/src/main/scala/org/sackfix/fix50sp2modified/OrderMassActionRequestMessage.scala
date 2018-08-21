package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class OrderMassActionRequestMessage(clOrdIDField:ClOrdIDField,
                                         secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                                         massActionTypeField:MassActionTypeField,
                                         massActionScopeField:MassActionScopeField,
                                         marketIDField:Option[MarketIDField]=None,
                                         marketSegmentIDField:Option[MarketSegmentIDField]=None,
                                         tradingSessionIDField:Option[TradingSessionIDField]=None,
                                         tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                         partiesComponent:Option[PartiesComponent]=None,
                                         targetPartiesComponent:Option[TargetPartiesComponent]=None,
                                         instrumentComponent:Option[InstrumentComponent]=None,
                                         underlyingInstrumentComponent:Option[UnderlyingInstrumentComponent]=None,
                                         sideField:Option[SideField]=None,
                                         transactTimeField:TransactTimeField,
                                         textField:Option[TextField]=None,
                                         encodedTextLenField:Option[EncodedTextLenField]=None,
                                         encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("CA")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,clOrdIDField)
    secondaryClOrdIDField.foreach(fmt(b,_))
    fmt(b,massActionTypeField)
    fmt(b,massActionScopeField)
    marketIDField.foreach(fmt(b,_))
    marketSegmentIDField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    targetPartiesComponent.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    underlyingInstrumentComponent.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    fmt(b,transactTimeField)
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object OrderMassActionRequestMessage extends SfFixMessageDecoder {
  val MsgType="CA"
  val MsgName="OrderMassActionRequest"
             
  override val MandatoryFields = HashSet[Int](
    ClOrdIDField.TagId, MassActionTypeField.TagId, MassActionScopeField.TagId, TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || TargetPartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || UnderlyingInstrumentComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecondaryClOrdIDField.TagId, MarketIDField.TagId, MarketSegmentIDField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, 
    SideField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || TargetPartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || UnderlyingInstrumentComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || TargetPartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || 
    UnderlyingInstrumentComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ClOrdIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(OrderMassActionRequestMessage(ClOrdIDField.decode(myFields.get(ClOrdIDField.TagId)).get,
        myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
        MassActionTypeField.decode(myFields.get(MassActionTypeField.TagId)).get,
        MassActionScopeField.decode(myFields.get(MassActionScopeField.TagId)).get,
        myFields.get(MarketIDField.TagId).flatMap(f=>MarketIDField.decode(f)),
        myFields.get(MarketSegmentIDField.TagId).flatMap(f=>MarketSegmentIDField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        TargetPartiesComponent.decode(flds, startPos),
        InstrumentComponent.decode(flds, startPos),
        UnderlyingInstrumentComponent.decode(flds, startPos),
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     