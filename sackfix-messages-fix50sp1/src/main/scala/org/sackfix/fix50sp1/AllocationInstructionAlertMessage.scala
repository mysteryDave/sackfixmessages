package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class AllocationInstructionAlertMessage(allocIDField:AllocIDField,
                                             allocTransTypeField:AllocTransTypeField,
                                             allocTypeField:AllocTypeField,
                                             secondaryAllocIDField:Option[SecondaryAllocIDField]=None,
                                             refAllocIDField:Option[RefAllocIDField]=None,
                                             allocCancReplaceReasonField:Option[AllocCancReplaceReasonField]=None,
                                             allocIntermedReqTypeField:Option[AllocIntermedReqTypeField]=None,
                                             allocLinkIDField:Option[AllocLinkIDField]=None,
                                             allocLinkTypeField:Option[AllocLinkTypeField]=None,
                                             bookingRefIDField:Option[BookingRefIDField]=None,
                                             allocNoOrdersTypeField:Option[AllocNoOrdersTypeField]=None,
                                             ordAllocGrpComponent:Option[OrdAllocGrpComponent]=None,
                                             execAllocGrpComponent:Option[ExecAllocGrpComponent]=None,
                                             previouslyReportedField:Option[PreviouslyReportedField]=None,
                                             reversalIndicatorField:Option[ReversalIndicatorField]=None,
                                             matchTypeField:Option[MatchTypeField]=None,
                                             sideField:SideField,
                                             instrumentComponent:InstrumentComponent,
                                             instrumentExtensionComponent:Option[InstrumentExtensionComponent]=None,
                                             financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                             undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                             instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                             quantityField:QuantityField,
                                             qtyTypeField:Option[QtyTypeField]=None,
                                             lastMktField:Option[LastMktField]=None,
                                             tradeOriginationDateField:Option[TradeOriginationDateField]=None,
                                             tradingSessionIDField:Option[TradingSessionIDField]=None,
                                             tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                             priceTypeField:Option[PriceTypeField]=None,
                                             avgPxField:Option[AvgPxField]=None,
                                             avgParPxField:Option[AvgParPxField]=None,
                                             spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                             currencyField:Option[CurrencyField]=None,
                                             avgPxPrecisionField:Option[AvgPxPrecisionField]=None,
                                             partiesComponent:Option[PartiesComponent]=None,
                                             tradeDateField:TradeDateField,
                                             transactTimeField:Option[TransactTimeField]=None,
                                             settlTypeField:Option[SettlTypeField]=None,
                                             settlDateField:Option[SettlDateField]=None,
                                             bookingTypeField:Option[BookingTypeField]=None,
                                             grossTradeAmtField:Option[GrossTradeAmtField]=None,
                                             concessionField:Option[ConcessionField]=None,
                                             totalTakedownField:Option[TotalTakedownField]=None,
                                             netMoneyField:Option[NetMoneyField]=None,
                                             positionEffectField:Option[PositionEffectField]=None,
                                             autoAcceptIndicatorField:Option[AutoAcceptIndicatorField]=None,
                                             textField:Option[TextField]=None,
                                             encodedTextLenField:Option[EncodedTextLenField]=None,
                                             encodedTextField:Option[EncodedTextField]=None,
                                             numDaysInterestField:Option[NumDaysInterestField]=None,
                                             accruedInterestRateField:Option[AccruedInterestRateField]=None,
                                             accruedInterestAmtField:Option[AccruedInterestAmtField]=None,
                                             totalAccruedInterestAmtField:Option[TotalAccruedInterestAmtField]=None,
                                             interestAtMaturityField:Option[InterestAtMaturityField]=None,
                                             endAccruedInterestAmtField:Option[EndAccruedInterestAmtField]=None,
                                             startCashField:Option[StartCashField]=None,
                                             endCashField:Option[EndCashField]=None,
                                             legalConfirmField:Option[LegalConfirmField]=None,
                                             stipulationsComponent:Option[StipulationsComponent]=None,
                                             yieldDataComponent:Option[YieldDataComponent]=None,
                                             positionAmountDataComponent:Option[PositionAmountDataComponent]=None,
                                             totNoAllocsField:Option[TotNoAllocsField]=None,
                                             lastFragmentField:Option[LastFragmentField]=None,
                                             allocGrpComponent:Option[AllocGrpComponent]=None,
                                             avgPxIndicatorField:Option[AvgPxIndicatorField]=None,
                                             clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                             trdTypeField:Option[TrdTypeField]=None,
                                             trdSubTypeField:Option[TrdSubTypeField]=None,
                                             custOrderCapacityField:Option[CustOrderCapacityField]=None,
                                             tradeInputSourceField:Option[TradeInputSourceField]=None,
                                             multiLegReportingTypeField:Option[MultiLegReportingTypeField]=None,
                                             messageEventSourceField:Option[MessageEventSourceField]=None,
                                             rndPxField:Option[RndPxField]=None) extends SfFixMessageBody("BM")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,allocIDField)
    fmt(b,allocTransTypeField)
    fmt(b,allocTypeField)
    secondaryAllocIDField.foreach(fmt(b,_))
    refAllocIDField.foreach(fmt(b,_))
    allocCancReplaceReasonField.foreach(fmt(b,_))
    allocIntermedReqTypeField.foreach(fmt(b,_))
    allocLinkIDField.foreach(fmt(b,_))
    allocLinkTypeField.foreach(fmt(b,_))
    bookingRefIDField.foreach(fmt(b,_))
    allocNoOrdersTypeField.foreach(fmt(b,_))
    ordAllocGrpComponent.foreach(fmt(b,_))
    execAllocGrpComponent.foreach(fmt(b,_))
    previouslyReportedField.foreach(fmt(b,_))
    reversalIndicatorField.foreach(fmt(b,_))
    matchTypeField.foreach(fmt(b,_))
    fmt(b,sideField)
    fmt(b,instrumentComponent)
    instrumentExtensionComponent.foreach(fmt(b,_))
    financingDetailsComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    fmt(b,quantityField)
    qtyTypeField.foreach(fmt(b,_))
    lastMktField.foreach(fmt(b,_))
    tradeOriginationDateField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    avgPxField.foreach(fmt(b,_))
    avgParPxField.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    avgPxPrecisionField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    fmt(b,tradeDateField)
    transactTimeField.foreach(fmt(b,_))
    settlTypeField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    bookingTypeField.foreach(fmt(b,_))
    grossTradeAmtField.foreach(fmt(b,_))
    concessionField.foreach(fmt(b,_))
    totalTakedownField.foreach(fmt(b,_))
    netMoneyField.foreach(fmt(b,_))
    positionEffectField.foreach(fmt(b,_))
    autoAcceptIndicatorField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    numDaysInterestField.foreach(fmt(b,_))
    accruedInterestRateField.foreach(fmt(b,_))
    accruedInterestAmtField.foreach(fmt(b,_))
    totalAccruedInterestAmtField.foreach(fmt(b,_))
    interestAtMaturityField.foreach(fmt(b,_))
    endAccruedInterestAmtField.foreach(fmt(b,_))
    startCashField.foreach(fmt(b,_))
    endCashField.foreach(fmt(b,_))
    legalConfirmField.foreach(fmt(b,_))
    stipulationsComponent.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    positionAmountDataComponent.foreach(fmt(b,_))
    totNoAllocsField.foreach(fmt(b,_))
    lastFragmentField.foreach(fmt(b,_))
    allocGrpComponent.foreach(fmt(b,_))
    avgPxIndicatorField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    trdTypeField.foreach(fmt(b,_))
    trdSubTypeField.foreach(fmt(b,_))
    custOrderCapacityField.foreach(fmt(b,_))
    tradeInputSourceField.foreach(fmt(b,_))
    multiLegReportingTypeField.foreach(fmt(b,_))
    messageEventSourceField.foreach(fmt(b,_))
    rndPxField.foreach(fmt(b,_))
    b
  }

}
     
object AllocationInstructionAlertMessage extends SfFixMessageDecoder {
  val MsgType="BM"
  val MsgName="AllocationInstructionAlert"
             
  override val MandatoryFields = HashSet[Int](
    AllocIDField.TagId, AllocTransTypeField.TagId, AllocTypeField.TagId, SideField.TagId, QuantityField.TagId, 
    TradeDateField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OrdAllocGrpComponent.isMandatoryField(tagId) || ExecAllocGrpComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || InstrumentExtensionComponent.isMandatoryField(tagId) || 
    FinancingDetailsComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || 
    PartiesComponent.isMandatoryField(tagId) || StipulationsComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId) || PositionAmountDataComponent.isMandatoryField(tagId) || 
    AllocGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecondaryAllocIDField.TagId, RefAllocIDField.TagId, AllocCancReplaceReasonField.TagId, AllocIntermedReqTypeField.TagId, AllocLinkIDField.TagId, 
    AllocLinkTypeField.TagId, BookingRefIDField.TagId, AllocNoOrdersTypeField.TagId, PreviouslyReportedField.TagId, ReversalIndicatorField.TagId, 
    MatchTypeField.TagId, QtyTypeField.TagId, LastMktField.TagId, TradeOriginationDateField.TagId, TradingSessionIDField.TagId, 
    TradingSessionSubIDField.TagId, PriceTypeField.TagId, AvgPxField.TagId, AvgParPxField.TagId, CurrencyField.TagId, 
    AvgPxPrecisionField.TagId, TransactTimeField.TagId, SettlTypeField.TagId, SettlDateField.TagId, BookingTypeField.TagId, 
    GrossTradeAmtField.TagId, ConcessionField.TagId, TotalTakedownField.TagId, NetMoneyField.TagId, PositionEffectField.TagId, 
    AutoAcceptIndicatorField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, NumDaysInterestField.TagId, 
    AccruedInterestRateField.TagId, AccruedInterestAmtField.TagId, TotalAccruedInterestAmtField.TagId, InterestAtMaturityField.TagId, EndAccruedInterestAmtField.TagId, 
    StartCashField.TagId, EndCashField.TagId, LegalConfirmField.TagId, TotNoAllocsField.TagId, LastFragmentField.TagId, 
    AvgPxIndicatorField.TagId, ClearingBusinessDateField.TagId, TrdTypeField.TagId, TrdSubTypeField.TagId, CustOrderCapacityField.TagId, 
    TradeInputSourceField.TagId, MultiLegReportingTypeField.TagId, MessageEventSourceField.TagId, RndPxField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OrdAllocGrpComponent.isOptionalField(tagId) || ExecAllocGrpComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrumentExtensionComponent.isOptionalField(tagId) || 
    FinancingDetailsComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || 
    PartiesComponent.isOptionalField(tagId) || StipulationsComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId) || PositionAmountDataComponent.isOptionalField(tagId) || 
    AllocGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OrdAllocGrpComponent.isFieldOf(tagId) || ExecAllocGrpComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || 
    InstrumentExtensionComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || 
    InstrmtLegGrpComponent.isFieldOf(tagId) || SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || PartiesComponent.isFieldOf(tagId) || 
    StipulationsComponent.isFieldOf(tagId) || YieldDataComponent.isFieldOf(tagId) || PositionAmountDataComponent.isFieldOf(tagId) || 
    AllocGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==AllocIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(AllocationInstructionAlertMessage(AllocIDField.decode(myFields.get(AllocIDField.TagId)).get,
        AllocTransTypeField.decode(myFields.get(AllocTransTypeField.TagId)).get,
        AllocTypeField.decode(myFields.get(AllocTypeField.TagId)).get,
        myFields.get(SecondaryAllocIDField.TagId).flatMap(f=>SecondaryAllocIDField.decode(f)),
        myFields.get(RefAllocIDField.TagId).flatMap(f=>RefAllocIDField.decode(f)),
        myFields.get(AllocCancReplaceReasonField.TagId).flatMap(f=>AllocCancReplaceReasonField.decode(f)),
        myFields.get(AllocIntermedReqTypeField.TagId).flatMap(f=>AllocIntermedReqTypeField.decode(f)),
        myFields.get(AllocLinkIDField.TagId).flatMap(f=>AllocLinkIDField.decode(f)),
        myFields.get(AllocLinkTypeField.TagId).flatMap(f=>AllocLinkTypeField.decode(f)),
        myFields.get(BookingRefIDField.TagId).flatMap(f=>BookingRefIDField.decode(f)),
        myFields.get(AllocNoOrdersTypeField.TagId).flatMap(f=>AllocNoOrdersTypeField.decode(f)),
        OrdAllocGrpComponent.decode(flds, startPos),
        ExecAllocGrpComponent.decode(flds, startPos),
        myFields.get(PreviouslyReportedField.TagId).flatMap(f=>PreviouslyReportedField.decode(f)),
        myFields.get(ReversalIndicatorField.TagId).flatMap(f=>ReversalIndicatorField.decode(f)),
        myFields.get(MatchTypeField.TagId).flatMap(f=>MatchTypeField.decode(f)),
        SideField.decode(myFields.get(SideField.TagId)).get,
        InstrumentComponent.decode(flds, startPos).get,
        InstrumentExtensionComponent.decode(flds, startPos),
        FinancingDetailsComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        QuantityField.decode(myFields.get(QuantityField.TagId)).get,
        myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
        myFields.get(LastMktField.TagId).flatMap(f=>LastMktField.decode(f)),
        myFields.get(TradeOriginationDateField.TagId).flatMap(f=>TradeOriginationDateField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(AvgPxField.TagId).flatMap(f=>AvgPxField.decode(f)),
        myFields.get(AvgParPxField.TagId).flatMap(f=>AvgParPxField.decode(f)),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(AvgPxPrecisionField.TagId).flatMap(f=>AvgPxPrecisionField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        TradeDateField.decode(myFields.get(TradeDateField.TagId)).get,
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(SettlTypeField.TagId).flatMap(f=>SettlTypeField.decode(f)),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        myFields.get(BookingTypeField.TagId).flatMap(f=>BookingTypeField.decode(f)),
        myFields.get(GrossTradeAmtField.TagId).flatMap(f=>GrossTradeAmtField.decode(f)),
        myFields.get(ConcessionField.TagId).flatMap(f=>ConcessionField.decode(f)),
        myFields.get(TotalTakedownField.TagId).flatMap(f=>TotalTakedownField.decode(f)),
        myFields.get(NetMoneyField.TagId).flatMap(f=>NetMoneyField.decode(f)),
        myFields.get(PositionEffectField.TagId).flatMap(f=>PositionEffectField.decode(f)),
        myFields.get(AutoAcceptIndicatorField.TagId).flatMap(f=>AutoAcceptIndicatorField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(NumDaysInterestField.TagId).flatMap(f=>NumDaysInterestField.decode(f)),
        myFields.get(AccruedInterestRateField.TagId).flatMap(f=>AccruedInterestRateField.decode(f)),
        myFields.get(AccruedInterestAmtField.TagId).flatMap(f=>AccruedInterestAmtField.decode(f)),
        myFields.get(TotalAccruedInterestAmtField.TagId).flatMap(f=>TotalAccruedInterestAmtField.decode(f)),
        myFields.get(InterestAtMaturityField.TagId).flatMap(f=>InterestAtMaturityField.decode(f)),
        myFields.get(EndAccruedInterestAmtField.TagId).flatMap(f=>EndAccruedInterestAmtField.decode(f)),
        myFields.get(StartCashField.TagId).flatMap(f=>StartCashField.decode(f)),
        myFields.get(EndCashField.TagId).flatMap(f=>EndCashField.decode(f)),
        myFields.get(LegalConfirmField.TagId).flatMap(f=>LegalConfirmField.decode(f)),
        StipulationsComponent.decode(flds, startPos),
        YieldDataComponent.decode(flds, startPos),
        PositionAmountDataComponent.decode(flds, startPos),
        myFields.get(TotNoAllocsField.TagId).flatMap(f=>TotNoAllocsField.decode(f)),
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        AllocGrpComponent.decode(flds, startPos),
        myFields.get(AvgPxIndicatorField.TagId).flatMap(f=>AvgPxIndicatorField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(TrdTypeField.TagId).flatMap(f=>TrdTypeField.decode(f)),
        myFields.get(TrdSubTypeField.TagId).flatMap(f=>TrdSubTypeField.decode(f)),
        myFields.get(CustOrderCapacityField.TagId).flatMap(f=>CustOrderCapacityField.decode(f)),
        myFields.get(TradeInputSourceField.TagId).flatMap(f=>TradeInputSourceField.decode(f)),
        myFields.get(MultiLegReportingTypeField.TagId).flatMap(f=>MultiLegReportingTypeField.decode(f)),
        myFields.get(MessageEventSourceField.TagId).flatMap(f=>MessageEventSourceField.decode(f)),
        myFields.get(RndPxField.TagId).flatMap(f=>RndPxField.decode(f))))
    } else None
  }

    
}
     