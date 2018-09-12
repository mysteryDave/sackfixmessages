package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class MDEntriesGroup(mDUpdateActionField:MDUpdateActionField,
                          deleteReasonField:Option[DeleteReasonField]=None,
                          mDSubBookTypeField:Option[MDSubBookTypeField]=None,
                          marketDepthField:Option[MarketDepthField]=None,
                          mDEntryTypeField:Option[MDEntryTypeField]=None,
                          mDEntryIDField:Option[MDEntryIDField]=None,
                          mDEntryRefIDField:Option[MDEntryRefIDField]=None,
                          instrumentComponent:Option[InstrumentComponent]=None,
                          undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                          instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                          financialStatusField:Option[FinancialStatusField]=None,
                          corporateActionField:Option[CorporateActionField]=None,
                          mDEntryPxField:Option[MDEntryPxField]=None,
                          priceTypeField:Option[PriceTypeField]=None,
                          yieldDataComponent:Option[YieldDataComponent]=None,
                          spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                          ordTypeField:Option[OrdTypeField]=None,
                          currencyField:Option[CurrencyField]=None,
                          mDEntrySizeField:Option[MDEntrySizeField]=None,
                          secSizesGrpComponent:Option[SecSizesGrpComponent]=None,
                          lotTypeField:Option[LotTypeField]=None,
                          mDEntryDateField:Option[MDEntryDateField]=None,
                          mDEntryTimeField:Option[MDEntryTimeField]=None,
                          tickDirectionField:Option[TickDirectionField]=None,
                          mDMktField:Option[MDMktField]=None,
                          tradingSessionIDField:Option[TradingSessionIDField]=None,
                          tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                          securityTradingStatusField:Option[SecurityTradingStatusField]=None,
                          haltReasonField:Option[HaltReasonField]=None,
                          quoteConditionField:Option[QuoteConditionField]=None,
                          tradeConditionField:Option[TradeConditionField]=None,
                          trdTypeField:Option[TrdTypeField]=None,
                          matchTypeField:Option[MatchTypeField]=None,
                          mDEntryOriginatorField:Option[MDEntryOriginatorField]=None,
                          locationIDField:Option[LocationIDField]=None,
                          deskIDField:Option[DeskIDField]=None,
                          openCloseSettlFlagField:Option[OpenCloseSettlFlagField]=None,
                          timeInForceField:Option[TimeInForceField]=None,
                          expireDateField:Option[ExpireDateField]=None,
                          expireTimeField:Option[ExpireTimeField]=None,
                          minQtyField:Option[MinQtyField]=None,
                          execInstField:Option[ExecInstField]=None,
                          sellerDaysField:Option[SellerDaysField]=None,
                          orderIDField:Option[OrderIDField]=None,
                          secondaryOrderIDField:Option[SecondaryOrderIDField]=None,
                          quoteEntryIDField:Option[QuoteEntryIDField]=None,
                          tradeIDField:Option[TradeIDField]=None,
                          mDEntryBuyerField:Option[MDEntryBuyerField]=None,
                          mDEntrySellerField:Option[MDEntrySellerField]=None,
                          numberOfOrdersField:Option[NumberOfOrdersField]=None,
                          mDEntryPositionNoField:Option[MDEntryPositionNoField]=None,
                          scopeField:Option[ScopeField]=None,
                          priceDeltaField:Option[PriceDeltaField]=None,
                          netChgPrevDayField:Option[NetChgPrevDayField]=None,
                          textField:Option[TextField]=None,
                          encodedTextLenField:Option[EncodedTextLenField]=None,
                          encodedTextField:Option[EncodedTextField]=None,
                          mDPriceLevelField:Option[MDPriceLevelField]=None,
                          orderCapacityField:Option[OrderCapacityField]=None,
                          mDOriginTypeField:Option[MDOriginTypeField]=None,
                          highPxField:Option[HighPxField]=None,
                          lowPxField:Option[LowPxField]=None,
                          tradeVolumeField:Option[TradeVolumeField]=None,
                          settlTypeField:Option[SettlTypeField]=None,
                          settlDateField:Option[SettlDateField]=None,
                          transBkdTimeField:Option[TransBkdTimeField]=None,
                          transactTimeField:Option[TransactTimeField]=None,
                          mDQuoteTypeField:Option[MDQuoteTypeField]=None,
                          rptSeqField:Option[RptSeqField]=None,
                          dealingCapacityField:Option[DealingCapacityField]=None,
                          mDEntrySpotRateField:Option[MDEntrySpotRateField]=None,
                          mDEntryForwardPointsField:Option[MDEntryForwardPointsField]=None,
                          statsIndGrpComponent:Option[StatsIndGrpComponent]=None,
                          partiesComponent:Option[PartiesComponent]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,mDUpdateActionField)
    deleteReasonField.foreach(fmt(b,_))
    mDSubBookTypeField.foreach(fmt(b,_))
    marketDepthField.foreach(fmt(b,_))
    mDEntryTypeField.foreach(fmt(b,_))
    mDEntryIDField.foreach(fmt(b,_))
    mDEntryRefIDField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    financialStatusField.foreach(fmt(b,_))
    corporateActionField.foreach(fmt(b,_))
    mDEntryPxField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    ordTypeField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    mDEntrySizeField.foreach(fmt(b,_))
    secSizesGrpComponent.foreach(fmt(b,_))
    lotTypeField.foreach(fmt(b,_))
    mDEntryDateField.foreach(fmt(b,_))
    mDEntryTimeField.foreach(fmt(b,_))
    tickDirectionField.foreach(fmt(b,_))
    mDMktField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    securityTradingStatusField.foreach(fmt(b,_))
    haltReasonField.foreach(fmt(b,_))
    quoteConditionField.foreach(fmt(b,_))
    tradeConditionField.foreach(fmt(b,_))
    trdTypeField.foreach(fmt(b,_))
    matchTypeField.foreach(fmt(b,_))
    mDEntryOriginatorField.foreach(fmt(b,_))
    locationIDField.foreach(fmt(b,_))
    deskIDField.foreach(fmt(b,_))
    openCloseSettlFlagField.foreach(fmt(b,_))
    timeInForceField.foreach(fmt(b,_))
    expireDateField.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    minQtyField.foreach(fmt(b,_))
    execInstField.foreach(fmt(b,_))
    sellerDaysField.foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    secondaryOrderIDField.foreach(fmt(b,_))
    quoteEntryIDField.foreach(fmt(b,_))
    tradeIDField.foreach(fmt(b,_))
    mDEntryBuyerField.foreach(fmt(b,_))
    mDEntrySellerField.foreach(fmt(b,_))
    numberOfOrdersField.foreach(fmt(b,_))
    mDEntryPositionNoField.foreach(fmt(b,_))
    scopeField.foreach(fmt(b,_))
    priceDeltaField.foreach(fmt(b,_))
    netChgPrevDayField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    mDPriceLevelField.foreach(fmt(b,_))
    orderCapacityField.foreach(fmt(b,_))
    mDOriginTypeField.foreach(fmt(b,_))
    highPxField.foreach(fmt(b,_))
    lowPxField.foreach(fmt(b,_))
    tradeVolumeField.foreach(fmt(b,_))
    settlTypeField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    transBkdTimeField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    mDQuoteTypeField.foreach(fmt(b,_))
    rptSeqField.foreach(fmt(b,_))
    dealingCapacityField.foreach(fmt(b,_))
    mDEntrySpotRateField.foreach(fmt(b,_))
    mDEntryForwardPointsField.foreach(fmt(b,_))
    statsIndGrpComponent.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    b
  }

}
     
object MDEntriesGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int](
    MDUpdateActionField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || SecSizesGrpComponent.isMandatoryField(tagId) || StatsIndGrpComponent.isMandatoryField(tagId) || PartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    DeleteReasonField.TagId, MDSubBookTypeField.TagId, MarketDepthField.TagId, MDEntryTypeField.TagId, MDEntryIDField.TagId, 
    MDEntryRefIDField.TagId, FinancialStatusField.TagId, CorporateActionField.TagId, MDEntryPxField.TagId, PriceTypeField.TagId, 
    OrdTypeField.TagId, CurrencyField.TagId, MDEntrySizeField.TagId, LotTypeField.TagId, MDEntryDateField.TagId, 
    MDEntryTimeField.TagId, TickDirectionField.TagId, MDMktField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, 
    SecurityTradingStatusField.TagId, HaltReasonField.TagId, QuoteConditionField.TagId, TradeConditionField.TagId, TrdTypeField.TagId, 
    MatchTypeField.TagId, MDEntryOriginatorField.TagId, LocationIDField.TagId, DeskIDField.TagId, OpenCloseSettlFlagField.TagId, 
    TimeInForceField.TagId, ExpireDateField.TagId, ExpireTimeField.TagId, MinQtyField.TagId, ExecInstField.TagId, 
    SellerDaysField.TagId, OrderIDField.TagId, SecondaryOrderIDField.TagId, QuoteEntryIDField.TagId, TradeIDField.TagId, 
    MDEntryBuyerField.TagId, MDEntrySellerField.TagId, NumberOfOrdersField.TagId, MDEntryPositionNoField.TagId, ScopeField.TagId, 
    PriceDeltaField.TagId, NetChgPrevDayField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, 
    MDPriceLevelField.TagId, OrderCapacityField.TagId, MDOriginTypeField.TagId, HighPxField.TagId, LowPxField.TagId, 
    TradeVolumeField.TagId, SettlTypeField.TagId, SettlDateField.TagId, TransBkdTimeField.TagId, TransactTimeField.TagId, 
    MDQuoteTypeField.TagId, RptSeqField.TagId, DealingCapacityField.TagId, MDEntrySpotRateField.TagId, MDEntryForwardPointsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || SecSizesGrpComponent.isOptionalField(tagId) || StatsIndGrpComponent.isOptionalField(tagId) || PartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || 
    YieldDataComponent.isFieldOf(tagId) || SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || SecSizesGrpComponent.isFieldOf(tagId) || 
    StatsIndGrpComponent.isFieldOf(tagId) || PartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MDUpdateActionField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[MDEntriesGroup]=ArrayBuffer.empty[MDEntriesGroup]):Option[List[MDEntriesGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[MDEntriesGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[MDEntriesGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(MDEntriesGroup(MDUpdateActionField.decode(myFields.get(MDUpdateActionField.TagId)).get,
          myFields.get(DeleteReasonField.TagId).flatMap(f=>DeleteReasonField.decode(f)),
          myFields.get(MDSubBookTypeField.TagId).flatMap(f=>MDSubBookTypeField.decode(f)),
          myFields.get(MarketDepthField.TagId).flatMap(f=>MarketDepthField.decode(f)),
          myFields.get(MDEntryTypeField.TagId).flatMap(f=>MDEntryTypeField.decode(f)),
          myFields.get(MDEntryIDField.TagId).flatMap(f=>MDEntryIDField.decode(f)),
          myFields.get(MDEntryRefIDField.TagId).flatMap(f=>MDEntryRefIDField.decode(f)),
          InstrumentComponent.decode(flds, startPos),
          UndInstrmtGrpComponent.decode(flds, startPos),
          InstrmtLegGrpComponent.decode(flds, startPos),
          myFields.get(FinancialStatusField.TagId).flatMap(f=>FinancialStatusField.decode(f)),
          myFields.get(CorporateActionField.TagId).flatMap(f=>CorporateActionField.decode(f)),
          myFields.get(MDEntryPxField.TagId).flatMap(f=>MDEntryPxField.decode(f)),
          myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
          YieldDataComponent.decode(flds, startPos),
          SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
          myFields.get(OrdTypeField.TagId).flatMap(f=>OrdTypeField.decode(f)),
          myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
          myFields.get(MDEntrySizeField.TagId).flatMap(f=>MDEntrySizeField.decode(f)),
          SecSizesGrpComponent.decode(flds, startPos),
          myFields.get(LotTypeField.TagId).flatMap(f=>LotTypeField.decode(f)),
          myFields.get(MDEntryDateField.TagId).flatMap(f=>MDEntryDateField.decode(f)),
          myFields.get(MDEntryTimeField.TagId).flatMap(f=>MDEntryTimeField.decode(f)),
          myFields.get(TickDirectionField.TagId).flatMap(f=>TickDirectionField.decode(f)),
          myFields.get(MDMktField.TagId).flatMap(f=>MDMktField.decode(f)),
          myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
          myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
          myFields.get(SecurityTradingStatusField.TagId).flatMap(f=>SecurityTradingStatusField.decode(f)),
          myFields.get(HaltReasonField.TagId).flatMap(f=>HaltReasonField.decode(f)),
          myFields.get(QuoteConditionField.TagId).flatMap(f=>QuoteConditionField.decode(f)),
          myFields.get(TradeConditionField.TagId).flatMap(f=>TradeConditionField.decode(f)),
          myFields.get(TrdTypeField.TagId).flatMap(f=>TrdTypeField.decode(f)),
          myFields.get(MatchTypeField.TagId).flatMap(f=>MatchTypeField.decode(f)),
          myFields.get(MDEntryOriginatorField.TagId).flatMap(f=>MDEntryOriginatorField.decode(f)),
          myFields.get(LocationIDField.TagId).flatMap(f=>LocationIDField.decode(f)),
          myFields.get(DeskIDField.TagId).flatMap(f=>DeskIDField.decode(f)),
          myFields.get(OpenCloseSettlFlagField.TagId).flatMap(f=>OpenCloseSettlFlagField.decode(f)),
          myFields.get(TimeInForceField.TagId).flatMap(f=>TimeInForceField.decode(f)),
          myFields.get(ExpireDateField.TagId).flatMap(f=>ExpireDateField.decode(f)),
          myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
          myFields.get(MinQtyField.TagId).flatMap(f=>MinQtyField.decode(f)),
          myFields.get(ExecInstField.TagId).flatMap(f=>ExecInstField.decode(f)),
          myFields.get(SellerDaysField.TagId).flatMap(f=>SellerDaysField.decode(f)),
          myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
          myFields.get(SecondaryOrderIDField.TagId).flatMap(f=>SecondaryOrderIDField.decode(f)),
          myFields.get(QuoteEntryIDField.TagId).flatMap(f=>QuoteEntryIDField.decode(f)),
          myFields.get(TradeIDField.TagId).flatMap(f=>TradeIDField.decode(f)),
          myFields.get(MDEntryBuyerField.TagId).flatMap(f=>MDEntryBuyerField.decode(f)),
          myFields.get(MDEntrySellerField.TagId).flatMap(f=>MDEntrySellerField.decode(f)),
          myFields.get(NumberOfOrdersField.TagId).flatMap(f=>NumberOfOrdersField.decode(f)),
          myFields.get(MDEntryPositionNoField.TagId).flatMap(f=>MDEntryPositionNoField.decode(f)),
          myFields.get(ScopeField.TagId).flatMap(f=>ScopeField.decode(f)),
          myFields.get(PriceDeltaField.TagId).flatMap(f=>PriceDeltaField.decode(f)),
          myFields.get(NetChgPrevDayField.TagId).flatMap(f=>NetChgPrevDayField.decode(f)),
          myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
          myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
          myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
          myFields.get(MDPriceLevelField.TagId).flatMap(f=>MDPriceLevelField.decode(f)),
          myFields.get(OrderCapacityField.TagId).flatMap(f=>OrderCapacityField.decode(f)),
          myFields.get(MDOriginTypeField.TagId).flatMap(f=>MDOriginTypeField.decode(f)),
          myFields.get(HighPxField.TagId).flatMap(f=>HighPxField.decode(f)),
          myFields.get(LowPxField.TagId).flatMap(f=>LowPxField.decode(f)),
          myFields.get(TradeVolumeField.TagId).flatMap(f=>TradeVolumeField.decode(f)),
          myFields.get(SettlTypeField.TagId).flatMap(f=>SettlTypeField.decode(f)),
          myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
          myFields.get(TransBkdTimeField.TagId).flatMap(f=>TransBkdTimeField.decode(f)),
          myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
          myFields.get(MDQuoteTypeField.TagId).flatMap(f=>MDQuoteTypeField.decode(f)),
          myFields.get(RptSeqField.TagId).flatMap(f=>RptSeqField.decode(f)),
          myFields.get(DealingCapacityField.TagId).flatMap(f=>DealingCapacityField.decode(f)),
          myFields.get(MDEntrySpotRateField.TagId).flatMap(f=>MDEntrySpotRateField.decode(f)),
          myFields.get(MDEntryForwardPointsField.TagId).flatMap(f=>MDEntryForwardPointsField.decode(f)),
          StatsIndGrpComponent.decode(flds, startPos),
          PartiesComponent.decode(flds, startPos))))
      } else (startPos, None)
    }
  }
    
}
     