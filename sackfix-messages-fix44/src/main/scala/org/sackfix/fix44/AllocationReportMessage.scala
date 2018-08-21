package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class AllocationReportMessage(allocReportIDField:AllocReportIDField,
                                   allocIDField:Option[AllocIDField]=None,
                                   allocTransTypeField:AllocTransTypeField,
                                   allocReportRefIDField:Option[AllocReportRefIDField]=None,
                                   allocCancReplaceReasonField:Option[AllocCancReplaceReasonField]=None,
                                   secondaryAllocIDField:Option[SecondaryAllocIDField]=None,
                                   allocReportTypeField:AllocReportTypeField,
                                   allocStatusField:AllocStatusField,
                                   allocRejCodeField:Option[AllocRejCodeField]=None,
                                   refAllocIDField:Option[RefAllocIDField]=None,
                                   allocIntermedReqTypeField:Option[AllocIntermedReqTypeField]=None,
                                   allocLinkIDField:Option[AllocLinkIDField]=None,
                                   allocLinkTypeField:Option[AllocLinkTypeField]=None,
                                   bookingRefIDField:Option[BookingRefIDField]=None,
                                   allocNoOrdersTypeField:AllocNoOrdersTypeField,
                                   noOrdersField:Option[NoOrdersField]=None,
                                   ordersGroups: Option[List[OrdersGroup]]=None,
                                   noExecsField:Option[NoExecsField]=None,
                                   execsGroups: Option[List[ExecsGroup]]=None,
                                   previouslyReportedField:Option[PreviouslyReportedField]=None,
                                   reversalIndicatorField:Option[ReversalIndicatorField]=None,
                                   matchTypeField:Option[MatchTypeField]=None,
                                   sideField:SideField,
                                   instrumentComponent:InstrumentComponent,
                                   instrumentExtensionComponent:Option[InstrumentExtensionComponent]=None,
                                   financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                   noUnderlyingsField:Option[NoUnderlyingsField]=None,
                                   underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                                   noLegsField:Option[NoLegsField]=None,
                                   legsGroups: Option[List[LegsGroup]]=None,
                                   quantityField:QuantityField,
                                   qtyTypeField:Option[QtyTypeField]=None,
                                   lastMktField:Option[LastMktField]=None,
                                   tradeOriginationDateField:Option[TradeOriginationDateField]=None,
                                   tradingSessionIDField:Option[TradingSessionIDField]=None,
                                   tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                   priceTypeField:Option[PriceTypeField]=None,
                                   avgPxField:AvgPxField,
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
                                   totNoAllocsField:Option[TotNoAllocsField]=None,
                                   lastFragmentField:Option[LastFragmentField]=None,
                                   noAllocsField:NoAllocsField,
                                   allocsGroups: List[AllocsGroup]) extends SfFixMessageBody("AS")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noOrdersField.map(_.value).getOrElse(0) != ordersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoOrdersField.TagId,noOrdersField.map(_.value).getOrElse(0), ordersGroups.map(_.size).getOrElse(0))
  if (noExecsField.map(_.value).getOrElse(0) != execsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoExecsField.TagId,noExecsField.map(_.value).getOrElse(0), execsGroups.map(_.size).getOrElse(0))
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))
  if (noAllocsField.value != allocsGroups.size)
    throw SfRepeatingGroupCountException(NoAllocsField.TagId,noAllocsField.value, allocsGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,allocReportIDField)
    allocIDField.foreach(fmt(b,_))
    fmt(b,allocTransTypeField)
    allocReportRefIDField.foreach(fmt(b,_))
    allocCancReplaceReasonField.foreach(fmt(b,_))
    secondaryAllocIDField.foreach(fmt(b,_))
    fmt(b,allocReportTypeField)
    fmt(b,allocStatusField)
    allocRejCodeField.foreach(fmt(b,_))
    refAllocIDField.foreach(fmt(b,_))
    allocIntermedReqTypeField.foreach(fmt(b,_))
    allocLinkIDField.foreach(fmt(b,_))
    allocLinkTypeField.foreach(fmt(b,_))
    bookingRefIDField.foreach(fmt(b,_))
    fmt(b,allocNoOrdersTypeField)
    noOrdersField.foreach(fmt(b,_))
    ordersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noExecsField.foreach(fmt(b,_))
    execsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    previouslyReportedField.foreach(fmt(b,_))
    reversalIndicatorField.foreach(fmt(b,_))
    matchTypeField.foreach(fmt(b,_))
    fmt(b,sideField)
    fmt(b,instrumentComponent)
    instrumentExtensionComponent.foreach(fmt(b,_))
    financingDetailsComponent.foreach(fmt(b,_))
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    fmt(b,quantityField)
    qtyTypeField.foreach(fmt(b,_))
    lastMktField.foreach(fmt(b,_))
    tradeOriginationDateField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    fmt(b,avgPxField)
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
    totNoAllocsField.foreach(fmt(b,_))
    lastFragmentField.foreach(fmt(b,_))
    fmt(b,noAllocsField)
    b
  }

}
     
object AllocationReportMessage extends SfFixMessageDecoder {
  val MsgType="AS"
  val MsgName="AllocationReport"
             
  override val MandatoryFields = HashSet[Int](
    AllocReportIDField.TagId, AllocTransTypeField.TagId, AllocReportTypeField.TagId, AllocStatusField.TagId, AllocNoOrdersTypeField.TagId, 
    SideField.TagId, QuantityField.TagId, AvgPxField.TagId, TradeDateField.TagId, NoAllocsField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OrdersGroup.isMandatoryField(tagId) || ExecsGroup.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || InstrumentExtensionComponent.isMandatoryField(tagId) || 
    FinancingDetailsComponent.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || 
    PartiesComponent.isMandatoryField(tagId) || StipulationsComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId) || AllocsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    AllocIDField.TagId, AllocReportRefIDField.TagId, AllocCancReplaceReasonField.TagId, SecondaryAllocIDField.TagId, AllocRejCodeField.TagId, 
    RefAllocIDField.TagId, AllocIntermedReqTypeField.TagId, AllocLinkIDField.TagId, AllocLinkTypeField.TagId, BookingRefIDField.TagId, 
    NoOrdersField.TagId, NoExecsField.TagId, PreviouslyReportedField.TagId, ReversalIndicatorField.TagId, MatchTypeField.TagId, 
    NoUnderlyingsField.TagId, NoLegsField.TagId, QtyTypeField.TagId, LastMktField.TagId, TradeOriginationDateField.TagId, 
    TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, PriceTypeField.TagId, AvgParPxField.TagId, CurrencyField.TagId, 
    AvgPxPrecisionField.TagId, TransactTimeField.TagId, SettlTypeField.TagId, SettlDateField.TagId, BookingTypeField.TagId, 
    GrossTradeAmtField.TagId, ConcessionField.TagId, TotalTakedownField.TagId, NetMoneyField.TagId, PositionEffectField.TagId, 
    AutoAcceptIndicatorField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, NumDaysInterestField.TagId, 
    AccruedInterestRateField.TagId, AccruedInterestAmtField.TagId, TotalAccruedInterestAmtField.TagId, InterestAtMaturityField.TagId, EndAccruedInterestAmtField.TagId, 
    StartCashField.TagId, EndCashField.TagId, LegalConfirmField.TagId, TotNoAllocsField.TagId, LastFragmentField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OrdersGroup.isOptionalField(tagId) || ExecsGroup.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrumentExtensionComponent.isOptionalField(tagId) || 
    FinancingDetailsComponent.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || 
    PartiesComponent.isOptionalField(tagId) || StipulationsComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId) || AllocsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OrdersGroup.isFieldOf(tagId) || ExecsGroup.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || 
    InstrumentExtensionComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || UnderlyingsGroup.isFieldOf(tagId) || 
    LegsGroup.isFieldOf(tagId) || SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || PartiesComponent.isFieldOf(tagId) || 
    StipulationsComponent.isFieldOf(tagId) || YieldDataComponent.isFieldOf(tagId) || AllocsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoOrdersField.TagId, NoExecsField.TagId, NoUnderlyingsField.TagId, NoLegsField.TagId, NoAllocsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==AllocReportIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(AllocationReportMessage(AllocReportIDField.decode(myFields.get(AllocReportIDField.TagId)).get,
        myFields.get(AllocIDField.TagId).flatMap(f=>AllocIDField.decode(f)),
        AllocTransTypeField.decode(myFields.get(AllocTransTypeField.TagId)).get,
        myFields.get(AllocReportRefIDField.TagId).flatMap(f=>AllocReportRefIDField.decode(f)),
        myFields.get(AllocCancReplaceReasonField.TagId).flatMap(f=>AllocCancReplaceReasonField.decode(f)),
        myFields.get(SecondaryAllocIDField.TagId).flatMap(f=>SecondaryAllocIDField.decode(f)),
        AllocReportTypeField.decode(myFields.get(AllocReportTypeField.TagId)).get,
        AllocStatusField.decode(myFields.get(AllocStatusField.TagId)).get,
        myFields.get(AllocRejCodeField.TagId).flatMap(f=>AllocRejCodeField.decode(f)),
        myFields.get(RefAllocIDField.TagId).flatMap(f=>RefAllocIDField.decode(f)),
        myFields.get(AllocIntermedReqTypeField.TagId).flatMap(f=>AllocIntermedReqTypeField.decode(f)),
        myFields.get(AllocLinkIDField.TagId).flatMap(f=>AllocLinkIDField.decode(f)),
        myFields.get(AllocLinkTypeField.TagId).flatMap(f=>AllocLinkTypeField.decode(f)),
        myFields.get(BookingRefIDField.TagId).flatMap(f=>BookingRefIDField.decode(f)),
        AllocNoOrdersTypeField.decode(myFields.get(AllocNoOrdersTypeField.TagId)).get,
        myFields.get(NoOrdersField.TagId).flatMap(f=>NoOrdersField.decode(f)),
        if (nextTagPosLookup.contains(NoOrdersField.TagId)) OrdersGroup.decode(flds, nextTagPosLookup(NoOrdersField.TagId)) else None,
        myFields.get(NoExecsField.TagId).flatMap(f=>NoExecsField.decode(f)),
        if (nextTagPosLookup.contains(NoExecsField.TagId)) ExecsGroup.decode(flds, nextTagPosLookup(NoExecsField.TagId)) else None,
        myFields.get(PreviouslyReportedField.TagId).flatMap(f=>PreviouslyReportedField.decode(f)),
        myFields.get(ReversalIndicatorField.TagId).flatMap(f=>ReversalIndicatorField.decode(f)),
        myFields.get(MatchTypeField.TagId).flatMap(f=>MatchTypeField.decode(f)),
        SideField.decode(myFields.get(SideField.TagId)).get,
        InstrumentComponent.decode(flds, startPos).get,
        InstrumentExtensionComponent.decode(flds, startPos),
        FinancingDetailsComponent.decode(flds, startPos),
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
        QuantityField.decode(myFields.get(QuantityField.TagId)).get,
        myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
        myFields.get(LastMktField.TagId).flatMap(f=>LastMktField.decode(f)),
        myFields.get(TradeOriginationDateField.TagId).flatMap(f=>TradeOriginationDateField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        AvgPxField.decode(myFields.get(AvgPxField.TagId)).get,
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
        myFields.get(TotNoAllocsField.TagId).flatMap(f=>TotNoAllocsField.decode(f)),
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        NoAllocsField.decode(myFields.get(NoAllocsField.TagId)).get,
        if (nextTagPosLookup.contains(NoAllocsField.TagId)) AllocsGroup.decode(flds, nextTagPosLookup(NoAllocsField.TagId)).get else List.empty))
    } else None
  }

    
}
     