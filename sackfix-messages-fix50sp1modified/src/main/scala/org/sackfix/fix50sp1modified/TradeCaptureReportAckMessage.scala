package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class TradeCaptureReportAckMessage(tradeReportIDField:Option[TradeReportIDField]=None,
                                        tradeIDField:Option[TradeIDField]=None,
                                        secondaryTradeIDField:Option[SecondaryTradeIDField]=None,
                                        firmTradeIDField:Option[FirmTradeIDField]=None,
                                        secondaryFirmTradeIDField:Option[SecondaryFirmTradeIDField]=None,
                                        tradeReportTransTypeField:Option[TradeReportTransTypeField]=None,
                                        tradeReportTypeField:Option[TradeReportTypeField]=None,
                                        trdTypeField:Option[TrdTypeField]=None,
                                        trdSubTypeField:Option[TrdSubTypeField]=None,
                                        secondaryTrdTypeField:Option[SecondaryTrdTypeField]=None,
                                        tradeHandlingInstrField:Option[TradeHandlingInstrField]=None,
                                        origTradeHandlingInstrField:Option[OrigTradeHandlingInstrField]=None,
                                        origTradeDateField:Option[OrigTradeDateField]=None,
                                        origTradeIDField:Option[OrigTradeIDField]=None,
                                        origSecondaryTradeIDField:Option[OrigSecondaryTradeIDField]=None,
                                        transferReasonField:Option[TransferReasonField]=None,
                                        rootPartiesComponent:Option[RootPartiesComponent]=None,
                                        execTypeField:Option[ExecTypeField]=None,
                                        tradeReportRefIDField:Option[TradeReportRefIDField]=None,
                                        secondaryTradeReportRefIDField:Option[SecondaryTradeReportRefIDField]=None,
                                        trdRptStatusField:Option[TrdRptStatusField]=None,
                                        tradeReportRejectReasonField:Option[TradeReportRejectReasonField]=None,
                                        secondaryTradeReportIDField:Option[SecondaryTradeReportIDField]=None,
                                        subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None,
                                        tradeLinkIDField:Option[TradeLinkIDField]=None,
                                        trdMatchIDField:Option[TrdMatchIDField]=None,
                                        execIDField:Option[ExecIDField]=None,
                                        secondaryExecIDField:Option[SecondaryExecIDField]=None,
                                        ordStatusField:Option[OrdStatusField]=None,
                                        execRestatementReasonField:Option[ExecRestatementReasonField]=None,
                                        previouslyReportedField:Option[PreviouslyReportedField]=None,
                                        priceTypeField:Option[PriceTypeField]=None,
                                        underlyingTradingSessionIDField:Option[UnderlyingTradingSessionIDField]=None,
                                        underlyingTradingSessionSubIDField:Option[UnderlyingTradingSessionSubIDField]=None,
                                        settlSessIDField:Option[SettlSessIDField]=None,
                                        settlSessSubIDField:Option[SettlSessSubIDField]=None,
                                        qtyTypeField:Option[QtyTypeField]=None,
                                        lastQtyField:Option[LastQtyField]=None,
                                        lastPxField:Option[LastPxField]=None,
                                        instrumentComponent:InstrumentComponent,
                                        lastParPxField:Option[LastParPxField]=None,
                                        calculatedCcyLastQtyField:Option[CalculatedCcyLastQtyField]=None,
                                        lastSwapPointsField:Option[LastSwapPointsField]=None,
                                        currencyField:Option[CurrencyField]=None,
                                        settlCurrencyField:Option[SettlCurrencyField]=None,
                                        lastSpotRateField:Option[LastSpotRateField]=None,
                                        lastForwardPointsField:Option[LastForwardPointsField]=None,
                                        lastMktField:Option[LastMktField]=None,
                                        tradeDateField:Option[TradeDateField]=None,
                                        clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                        avgPxField:Option[AvgPxField]=None,
                                        avgPxIndicatorField:Option[AvgPxIndicatorField]=None,
                                        multiLegReportingTypeField:Option[MultiLegReportingTypeField]=None,
                                        tradeLegRefIDField:Option[TradeLegRefIDField]=None,
                                        transactTimeField:Option[TransactTimeField]=None,
                                        settlTypeField:Option[SettlTypeField]=None,
                                        undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                        matchStatusField:Option[MatchStatusField]=None,
                                        matchTypeField:Option[MatchTypeField]=None,
                                        copyMsgIndicatorField:Option[CopyMsgIndicatorField]=None,
                                        trdRepIndicatorsGrpComponent:Option[TrdRepIndicatorsGrpComponent]=None,
                                        publishTrdIndicatorField:Option[PublishTrdIndicatorField]=None,
                                        tradePublishIndicatorField:Option[TradePublishIndicatorField]=None,
                                        shortSaleReasonField:Option[ShortSaleReasonField]=None,
                                        trdInstrmtLegGrpComponent:Option[TrdInstrmtLegGrpComponent]=None,
                                        trdRegTimestampsComponent:Option[TrdRegTimestampsComponent]=None,
                                        responseTransportTypeField:Option[ResponseTransportTypeField]=None,
                                        responseDestinationField:Option[ResponseDestinationField]=None,
                                        textField:Option[TextField]=None,
                                        encodedTextLenField:Option[EncodedTextLenField]=None,
                                        encodedTextField:Option[EncodedTextField]=None,
                                        asOfIndicatorField:Option[AsOfIndicatorField]=None,
                                        clearingFeeIndicatorField:Option[ClearingFeeIndicatorField]=None,
                                        positionAmountDataComponent:Option[PositionAmountDataComponent]=None,
                                        tierCodeField:Option[TierCodeField]=None,
                                        messageEventSourceField:Option[MessageEventSourceField]=None,
                                        lastUpdateTimeField:Option[LastUpdateTimeField]=None,
                                        rndPxField:Option[RndPxField]=None,
                                        trdCapRptAckSideGrpComponent:Option[TrdCapRptAckSideGrpComponent]=None,
                                        rptSysField:Option[RptSysField]=None,
                                        grossTradeAmtField:Option[GrossTradeAmtField]=None,
                                        settlDateField:Option[SettlDateField]=None,
                                        feeMultiplierField:Option[FeeMultiplierField]=None) extends SfFixMessageBody("AR")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    tradeReportIDField.foreach(fmt(b,_))
    tradeIDField.foreach(fmt(b,_))
    secondaryTradeIDField.foreach(fmt(b,_))
    firmTradeIDField.foreach(fmt(b,_))
    secondaryFirmTradeIDField.foreach(fmt(b,_))
    tradeReportTransTypeField.foreach(fmt(b,_))
    tradeReportTypeField.foreach(fmt(b,_))
    trdTypeField.foreach(fmt(b,_))
    trdSubTypeField.foreach(fmt(b,_))
    secondaryTrdTypeField.foreach(fmt(b,_))
    tradeHandlingInstrField.foreach(fmt(b,_))
    origTradeHandlingInstrField.foreach(fmt(b,_))
    origTradeDateField.foreach(fmt(b,_))
    origTradeIDField.foreach(fmt(b,_))
    origSecondaryTradeIDField.foreach(fmt(b,_))
    transferReasonField.foreach(fmt(b,_))
    rootPartiesComponent.foreach(fmt(b,_))
    execTypeField.foreach(fmt(b,_))
    tradeReportRefIDField.foreach(fmt(b,_))
    secondaryTradeReportRefIDField.foreach(fmt(b,_))
    trdRptStatusField.foreach(fmt(b,_))
    tradeReportRejectReasonField.foreach(fmt(b,_))
    secondaryTradeReportIDField.foreach(fmt(b,_))
    subscriptionRequestTypeField.foreach(fmt(b,_))
    tradeLinkIDField.foreach(fmt(b,_))
    trdMatchIDField.foreach(fmt(b,_))
    execIDField.foreach(fmt(b,_))
    secondaryExecIDField.foreach(fmt(b,_))
    ordStatusField.foreach(fmt(b,_))
    execRestatementReasonField.foreach(fmt(b,_))
    previouslyReportedField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    underlyingTradingSessionIDField.foreach(fmt(b,_))
    underlyingTradingSessionSubIDField.foreach(fmt(b,_))
    settlSessIDField.foreach(fmt(b,_))
    settlSessSubIDField.foreach(fmt(b,_))
    qtyTypeField.foreach(fmt(b,_))
    lastQtyField.foreach(fmt(b,_))
    lastPxField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    lastParPxField.foreach(fmt(b,_))
    calculatedCcyLastQtyField.foreach(fmt(b,_))
    lastSwapPointsField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    lastSpotRateField.foreach(fmt(b,_))
    lastForwardPointsField.foreach(fmt(b,_))
    lastMktField.foreach(fmt(b,_))
    tradeDateField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    avgPxField.foreach(fmt(b,_))
    avgPxIndicatorField.foreach(fmt(b,_))
    multiLegReportingTypeField.foreach(fmt(b,_))
    tradeLegRefIDField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    settlTypeField.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    matchStatusField.foreach(fmt(b,_))
    matchTypeField.foreach(fmt(b,_))
    copyMsgIndicatorField.foreach(fmt(b,_))
    trdRepIndicatorsGrpComponent.foreach(fmt(b,_))
    publishTrdIndicatorField.foreach(fmt(b,_))
    tradePublishIndicatorField.foreach(fmt(b,_))
    shortSaleReasonField.foreach(fmt(b,_))
    trdInstrmtLegGrpComponent.foreach(fmt(b,_))
    trdRegTimestampsComponent.foreach(fmt(b,_))
    responseTransportTypeField.foreach(fmt(b,_))
    responseDestinationField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    asOfIndicatorField.foreach(fmt(b,_))
    clearingFeeIndicatorField.foreach(fmt(b,_))
    positionAmountDataComponent.foreach(fmt(b,_))
    tierCodeField.foreach(fmt(b,_))
    messageEventSourceField.foreach(fmt(b,_))
    lastUpdateTimeField.foreach(fmt(b,_))
    rndPxField.foreach(fmt(b,_))
    trdCapRptAckSideGrpComponent.foreach(fmt(b,_))
    rptSysField.foreach(fmt(b,_))
    grossTradeAmtField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    feeMultiplierField.foreach(fmt(b,_))
    b
  }

}
     
object TradeCaptureReportAckMessage extends SfFixMessageDecoder {
  val MsgType="AR"
  val MsgName="TradeCaptureReportAck"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RootPartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || TrdRepIndicatorsGrpComponent.isMandatoryField(tagId) || 
    TrdInstrmtLegGrpComponent.isMandatoryField(tagId) || TrdRegTimestampsComponent.isMandatoryField(tagId) || PositionAmountDataComponent.isMandatoryField(tagId) || TrdCapRptAckSideGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TradeReportIDField.TagId, TradeIDField.TagId, SecondaryTradeIDField.TagId, FirmTradeIDField.TagId, SecondaryFirmTradeIDField.TagId, 
    TradeReportTransTypeField.TagId, TradeReportTypeField.TagId, TrdTypeField.TagId, TrdSubTypeField.TagId, SecondaryTrdTypeField.TagId, 
    TradeHandlingInstrField.TagId, OrigTradeHandlingInstrField.TagId, OrigTradeDateField.TagId, OrigTradeIDField.TagId, OrigSecondaryTradeIDField.TagId, 
    TransferReasonField.TagId, ExecTypeField.TagId, TradeReportRefIDField.TagId, SecondaryTradeReportRefIDField.TagId, TrdRptStatusField.TagId, 
    TradeReportRejectReasonField.TagId, SecondaryTradeReportIDField.TagId, SubscriptionRequestTypeField.TagId, TradeLinkIDField.TagId, TrdMatchIDField.TagId, 
    ExecIDField.TagId, SecondaryExecIDField.TagId, OrdStatusField.TagId, ExecRestatementReasonField.TagId, PreviouslyReportedField.TagId, 
    PriceTypeField.TagId, UnderlyingTradingSessionIDField.TagId, UnderlyingTradingSessionSubIDField.TagId, SettlSessIDField.TagId, SettlSessSubIDField.TagId, 
    QtyTypeField.TagId, LastQtyField.TagId, LastPxField.TagId, LastParPxField.TagId, CalculatedCcyLastQtyField.TagId, 
    LastSwapPointsField.TagId, CurrencyField.TagId, SettlCurrencyField.TagId, LastSpotRateField.TagId, LastForwardPointsField.TagId, 
    LastMktField.TagId, TradeDateField.TagId, ClearingBusinessDateField.TagId, AvgPxField.TagId, AvgPxIndicatorField.TagId, 
    MultiLegReportingTypeField.TagId, TradeLegRefIDField.TagId, TransactTimeField.TagId, SettlTypeField.TagId, MatchStatusField.TagId, 
    MatchTypeField.TagId, CopyMsgIndicatorField.TagId, PublishTrdIndicatorField.TagId, TradePublishIndicatorField.TagId, ShortSaleReasonField.TagId, 
    ResponseTransportTypeField.TagId, ResponseDestinationField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, 
    AsOfIndicatorField.TagId, ClearingFeeIndicatorField.TagId, TierCodeField.TagId, MessageEventSourceField.TagId, LastUpdateTimeField.TagId, 
    RndPxField.TagId, RptSysField.TagId, GrossTradeAmtField.TagId, SettlDateField.TagId, FeeMultiplierField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RootPartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || TrdRepIndicatorsGrpComponent.isOptionalField(tagId) || 
    TrdInstrmtLegGrpComponent.isOptionalField(tagId) || TrdRegTimestampsComponent.isOptionalField(tagId) || PositionAmountDataComponent.isOptionalField(tagId) || TrdCapRptAckSideGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RootPartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || 
    TrdRepIndicatorsGrpComponent.isFieldOf(tagId) || TrdInstrmtLegGrpComponent.isFieldOf(tagId) || TrdRegTimestampsComponent.isFieldOf(tagId) || 
    PositionAmountDataComponent.isFieldOf(tagId) || TrdCapRptAckSideGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==TradeReportIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(TradeCaptureReportAckMessage(myFields.get(TradeReportIDField.TagId).flatMap(f=>TradeReportIDField.decode(f)),
        myFields.get(TradeIDField.TagId).flatMap(f=>TradeIDField.decode(f)),
        myFields.get(SecondaryTradeIDField.TagId).flatMap(f=>SecondaryTradeIDField.decode(f)),
        myFields.get(FirmTradeIDField.TagId).flatMap(f=>FirmTradeIDField.decode(f)),
        myFields.get(SecondaryFirmTradeIDField.TagId).flatMap(f=>SecondaryFirmTradeIDField.decode(f)),
        myFields.get(TradeReportTransTypeField.TagId).flatMap(f=>TradeReportTransTypeField.decode(f)),
        myFields.get(TradeReportTypeField.TagId).flatMap(f=>TradeReportTypeField.decode(f)),
        myFields.get(TrdTypeField.TagId).flatMap(f=>TrdTypeField.decode(f)),
        myFields.get(TrdSubTypeField.TagId).flatMap(f=>TrdSubTypeField.decode(f)),
        myFields.get(SecondaryTrdTypeField.TagId).flatMap(f=>SecondaryTrdTypeField.decode(f)),
        myFields.get(TradeHandlingInstrField.TagId).flatMap(f=>TradeHandlingInstrField.decode(f)),
        myFields.get(OrigTradeHandlingInstrField.TagId).flatMap(f=>OrigTradeHandlingInstrField.decode(f)),
        myFields.get(OrigTradeDateField.TagId).flatMap(f=>OrigTradeDateField.decode(f)),
        myFields.get(OrigTradeIDField.TagId).flatMap(f=>OrigTradeIDField.decode(f)),
        myFields.get(OrigSecondaryTradeIDField.TagId).flatMap(f=>OrigSecondaryTradeIDField.decode(f)),
        myFields.get(TransferReasonField.TagId).flatMap(f=>TransferReasonField.decode(f)),
        RootPartiesComponent.decode(flds, startPos),
        myFields.get(ExecTypeField.TagId).flatMap(f=>ExecTypeField.decode(f)),
        myFields.get(TradeReportRefIDField.TagId).flatMap(f=>TradeReportRefIDField.decode(f)),
        myFields.get(SecondaryTradeReportRefIDField.TagId).flatMap(f=>SecondaryTradeReportRefIDField.decode(f)),
        myFields.get(TrdRptStatusField.TagId).flatMap(f=>TrdRptStatusField.decode(f)),
        myFields.get(TradeReportRejectReasonField.TagId).flatMap(f=>TradeReportRejectReasonField.decode(f)),
        myFields.get(SecondaryTradeReportIDField.TagId).flatMap(f=>SecondaryTradeReportIDField.decode(f)),
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f)),
        myFields.get(TradeLinkIDField.TagId).flatMap(f=>TradeLinkIDField.decode(f)),
        myFields.get(TrdMatchIDField.TagId).flatMap(f=>TrdMatchIDField.decode(f)),
        myFields.get(ExecIDField.TagId).flatMap(f=>ExecIDField.decode(f)),
        myFields.get(SecondaryExecIDField.TagId).flatMap(f=>SecondaryExecIDField.decode(f)),
        myFields.get(OrdStatusField.TagId).flatMap(f=>OrdStatusField.decode(f)),
        myFields.get(ExecRestatementReasonField.TagId).flatMap(f=>ExecRestatementReasonField.decode(f)),
        myFields.get(PreviouslyReportedField.TagId).flatMap(f=>PreviouslyReportedField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(UnderlyingTradingSessionIDField.TagId).flatMap(f=>UnderlyingTradingSessionIDField.decode(f)),
        myFields.get(UnderlyingTradingSessionSubIDField.TagId).flatMap(f=>UnderlyingTradingSessionSubIDField.decode(f)),
        myFields.get(SettlSessIDField.TagId).flatMap(f=>SettlSessIDField.decode(f)),
        myFields.get(SettlSessSubIDField.TagId).flatMap(f=>SettlSessSubIDField.decode(f)),
        myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
        myFields.get(LastQtyField.TagId).flatMap(f=>LastQtyField.decode(f)),
        myFields.get(LastPxField.TagId).flatMap(f=>LastPxField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        myFields.get(LastParPxField.TagId).flatMap(f=>LastParPxField.decode(f)),
        myFields.get(CalculatedCcyLastQtyField.TagId).flatMap(f=>CalculatedCcyLastQtyField.decode(f)),
        myFields.get(LastSwapPointsField.TagId).flatMap(f=>LastSwapPointsField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
        myFields.get(LastSpotRateField.TagId).flatMap(f=>LastSpotRateField.decode(f)),
        myFields.get(LastForwardPointsField.TagId).flatMap(f=>LastForwardPointsField.decode(f)),
        myFields.get(LastMktField.TagId).flatMap(f=>LastMktField.decode(f)),
        myFields.get(TradeDateField.TagId).flatMap(f=>TradeDateField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(AvgPxField.TagId).flatMap(f=>AvgPxField.decode(f)),
        myFields.get(AvgPxIndicatorField.TagId).flatMap(f=>AvgPxIndicatorField.decode(f)),
        myFields.get(MultiLegReportingTypeField.TagId).flatMap(f=>MultiLegReportingTypeField.decode(f)),
        myFields.get(TradeLegRefIDField.TagId).flatMap(f=>TradeLegRefIDField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(SettlTypeField.TagId).flatMap(f=>SettlTypeField.decode(f)),
        UndInstrmtGrpComponent.decode(flds, startPos),
        myFields.get(MatchStatusField.TagId).flatMap(f=>MatchStatusField.decode(f)),
        myFields.get(MatchTypeField.TagId).flatMap(f=>MatchTypeField.decode(f)),
        myFields.get(CopyMsgIndicatorField.TagId).flatMap(f=>CopyMsgIndicatorField.decode(f)),
        TrdRepIndicatorsGrpComponent.decode(flds, startPos),
        myFields.get(PublishTrdIndicatorField.TagId).flatMap(f=>PublishTrdIndicatorField.decode(f)),
        myFields.get(TradePublishIndicatorField.TagId).flatMap(f=>TradePublishIndicatorField.decode(f)),
        myFields.get(ShortSaleReasonField.TagId).flatMap(f=>ShortSaleReasonField.decode(f)),
        TrdInstrmtLegGrpComponent.decode(flds, startPos),
        TrdRegTimestampsComponent.decode(flds, startPos),
        myFields.get(ResponseTransportTypeField.TagId).flatMap(f=>ResponseTransportTypeField.decode(f)),
        myFields.get(ResponseDestinationField.TagId).flatMap(f=>ResponseDestinationField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(AsOfIndicatorField.TagId).flatMap(f=>AsOfIndicatorField.decode(f)),
        myFields.get(ClearingFeeIndicatorField.TagId).flatMap(f=>ClearingFeeIndicatorField.decode(f)),
        PositionAmountDataComponent.decode(flds, startPos),
        myFields.get(TierCodeField.TagId).flatMap(f=>TierCodeField.decode(f)),
        myFields.get(MessageEventSourceField.TagId).flatMap(f=>MessageEventSourceField.decode(f)),
        myFields.get(LastUpdateTimeField.TagId).flatMap(f=>LastUpdateTimeField.decode(f)),
        myFields.get(RndPxField.TagId).flatMap(f=>RndPxField.decode(f)),
        TrdCapRptAckSideGrpComponent.decode(flds, startPos),
        myFields.get(RptSysField.TagId).flatMap(f=>RptSysField.decode(f)),
        myFields.get(GrossTradeAmtField.TagId).flatMap(f=>GrossTradeAmtField.decode(f)),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        myFields.get(FeeMultiplierField.TagId).flatMap(f=>FeeMultiplierField.decode(f))))
    } else None
  }

    
}
     