package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class SecurityStatusMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                 securityStatusReqIDField:Option[SecurityStatusReqIDField]=None,
                                 instrumentComponent:InstrumentComponent,
                                 instrumentExtensionComponent:Option[InstrumentExtensionComponent]=None,
                                 undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                 instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                 currencyField:Option[CurrencyField]=None,
                                 marketIDField:Option[MarketIDField]=None,
                                 marketSegmentIDField:Option[MarketSegmentIDField]=None,
                                 tradingSessionIDField:Option[TradingSessionIDField]=None,
                                 tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                 unsolicitedIndicatorField:Option[UnsolicitedIndicatorField]=None,
                                 securityTradingStatusField:Option[SecurityTradingStatusField]=None,
                                 securityTradingEventField:Option[SecurityTradingEventField]=None,
                                 financialStatusField:Option[FinancialStatusField]=None,
                                 corporateActionField:Option[CorporateActionField]=None,
                                 haltReasonIntField:Option[HaltReasonIntField]=None,
                                 inViewOfCommonField:Option[InViewOfCommonField]=None,
                                 dueToRelatedField:Option[DueToRelatedField]=None,
                                 mDBookTypeField:Option[MDBookTypeField]=None,
                                 marketDepthField:Option[MarketDepthField]=None,
                                 buyVolumeField:Option[BuyVolumeField]=None,
                                 sellVolumeField:Option[SellVolumeField]=None,
                                 highPxField:Option[HighPxField]=None,
                                 lowPxField:Option[LowPxField]=None,
                                 lastPxField:Option[LastPxField]=None,
                                 transactTimeField:Option[TransactTimeField]=None,
                                 adjustmentField:Option[AdjustmentField]=None,
                                 firstPxField:Option[FirstPxField]=None,
                                 textField:Option[TextField]=None,
                                 encodedTextLenField:Option[EncodedTextLenField]=None,
                                 encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("f")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    securityStatusReqIDField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    instrumentExtensionComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    marketIDField.foreach(fmt(b,_))
    marketSegmentIDField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    unsolicitedIndicatorField.foreach(fmt(b,_))
    securityTradingStatusField.foreach(fmt(b,_))
    securityTradingEventField.foreach(fmt(b,_))
    financialStatusField.foreach(fmt(b,_))
    corporateActionField.foreach(fmt(b,_))
    haltReasonIntField.foreach(fmt(b,_))
    inViewOfCommonField.foreach(fmt(b,_))
    dueToRelatedField.foreach(fmt(b,_))
    mDBookTypeField.foreach(fmt(b,_))
    marketDepthField.foreach(fmt(b,_))
    buyVolumeField.foreach(fmt(b,_))
    sellVolumeField.foreach(fmt(b,_))
    highPxField.foreach(fmt(b,_))
    lowPxField.foreach(fmt(b,_))
    lastPxField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    adjustmentField.foreach(fmt(b,_))
    firstPxField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object SecurityStatusMessage extends SfFixMessageDecoder {
  val MsgType="f"
  val MsgName="SecurityStatus"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || InstrumentExtensionComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || 
    InstrmtLegGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecurityStatusReqIDField.TagId, CurrencyField.TagId, MarketIDField.TagId, MarketSegmentIDField.TagId, TradingSessionIDField.TagId, 
    TradingSessionSubIDField.TagId, UnsolicitedIndicatorField.TagId, SecurityTradingStatusField.TagId, SecurityTradingEventField.TagId, FinancialStatusField.TagId, 
    CorporateActionField.TagId, HaltReasonIntField.TagId, InViewOfCommonField.TagId, DueToRelatedField.TagId, MDBookTypeField.TagId, 
    MarketDepthField.TagId, BuyVolumeField.TagId, SellVolumeField.TagId, HighPxField.TagId, LowPxField.TagId, 
    LastPxField.TagId, TransactTimeField.TagId, AdjustmentField.TagId, FirstPxField.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrumentExtensionComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || 
    InstrmtLegGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || InstrumentExtensionComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SecurityStatusMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        myFields.get(SecurityStatusReqIDField.TagId).flatMap(f=>SecurityStatusReqIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        InstrumentExtensionComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(MarketIDField.TagId).flatMap(f=>MarketIDField.decode(f)),
        myFields.get(MarketSegmentIDField.TagId).flatMap(f=>MarketSegmentIDField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(UnsolicitedIndicatorField.TagId).flatMap(f=>UnsolicitedIndicatorField.decode(f)),
        myFields.get(SecurityTradingStatusField.TagId).flatMap(f=>SecurityTradingStatusField.decode(f)),
        myFields.get(SecurityTradingEventField.TagId).flatMap(f=>SecurityTradingEventField.decode(f)),
        myFields.get(FinancialStatusField.TagId).flatMap(f=>FinancialStatusField.decode(f)),
        myFields.get(CorporateActionField.TagId).flatMap(f=>CorporateActionField.decode(f)),
        myFields.get(HaltReasonIntField.TagId).flatMap(f=>HaltReasonIntField.decode(f)),
        myFields.get(InViewOfCommonField.TagId).flatMap(f=>InViewOfCommonField.decode(f)),
        myFields.get(DueToRelatedField.TagId).flatMap(f=>DueToRelatedField.decode(f)),
        myFields.get(MDBookTypeField.TagId).flatMap(f=>MDBookTypeField.decode(f)),
        myFields.get(MarketDepthField.TagId).flatMap(f=>MarketDepthField.decode(f)),
        myFields.get(BuyVolumeField.TagId).flatMap(f=>BuyVolumeField.decode(f)),
        myFields.get(SellVolumeField.TagId).flatMap(f=>SellVolumeField.decode(f)),
        myFields.get(HighPxField.TagId).flatMap(f=>HighPxField.decode(f)),
        myFields.get(LowPxField.TagId).flatMap(f=>LowPxField.decode(f)),
        myFields.get(LastPxField.TagId).flatMap(f=>LastPxField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(AdjustmentField.TagId).flatMap(f=>AdjustmentField.decode(f)),
        myFields.get(FirstPxField.TagId).flatMap(f=>FirstPxField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     