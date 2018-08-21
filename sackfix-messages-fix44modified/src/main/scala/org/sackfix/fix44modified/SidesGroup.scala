package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class SidesGroup(sideField:SideField,
                      orderIDField:OrderIDField,
                      secondaryOrderIDField:Option[SecondaryOrderIDField]=None,
                      clOrdIDField:Option[ClOrdIDField]=None,
                      secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                      listIDField:Option[ListIDField]=None,
                      partiesComponent:Option[PartiesComponent]=None,
                      accountField:Option[AccountField]=None,
                      acctIDSourceField:Option[AcctIDSourceField]=None,
                      accountTypeField:Option[AccountTypeField]=None,
                      processCodeField:Option[ProcessCodeField]=None,
                      oddLotField:Option[OddLotField]=None,
                      noClearingInstructionsField:Option[NoClearingInstructionsField]=None,
                      clearingInstructionsGroups: Option[List[ClearingInstructionsGroup]]=None,
                      clearingFeeIndicatorField:Option[ClearingFeeIndicatorField]=None,
                      tradeInputSourceField:Option[TradeInputSourceField]=None,
                      tradeInputDeviceField:Option[TradeInputDeviceField]=None,
                      orderInputDeviceField:Option[OrderInputDeviceField]=None,
                      currencyField:Option[CurrencyField]=None,
                      complianceIDField:Option[ComplianceIDField]=None,
                      solicitedFlagField:Option[SolicitedFlagField]=None,
                      orderCapacityField:Option[OrderCapacityField]=None,
                      orderRestrictionsField:Option[OrderRestrictionsField]=None,
                      custOrderCapacityField:Option[CustOrderCapacityField]=None,
                      ordTypeField:Option[OrdTypeField]=None,
                      execInstField:Option[ExecInstField]=None,
                      transBkdTimeField:Option[TransBkdTimeField]=None,
                      tradingSessionIDField:Option[TradingSessionIDField]=None,
                      tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                      timeBracketField:Option[TimeBracketField]=None,
                      commissionDataComponent:Option[CommissionDataComponent]=None,
                      grossTradeAmtField:Option[GrossTradeAmtField]=None,
                      numDaysInterestField:Option[NumDaysInterestField]=None,
                      exDateField:Option[ExDateField]=None,
                      accruedInterestRateField:Option[AccruedInterestRateField]=None,
                      accruedInterestAmtField:Option[AccruedInterestAmtField]=None,
                      interestAtMaturityField:Option[InterestAtMaturityField]=None,
                      endAccruedInterestAmtField:Option[EndAccruedInterestAmtField]=None,
                      startCashField:Option[StartCashField]=None,
                      endCashField:Option[EndCashField]=None,
                      concessionField:Option[ConcessionField]=None,
                      totalTakedownField:Option[TotalTakedownField]=None,
                      netMoneyField:Option[NetMoneyField]=None,
                      settlCurrAmtField:Option[SettlCurrAmtField]=None,
                      settlCurrencyField:Option[SettlCurrencyField]=None,
                      settlCurrFxRateField:Option[SettlCurrFxRateField]=None,
                      settlCurrFxRateCalcField:Option[SettlCurrFxRateCalcField]=None,
                      positionEffectField:Option[PositionEffectField]=None,
                      textField:Option[TextField]=None,
                      encodedTextLenField:Option[EncodedTextLenField]=None,
                      encodedTextField:Option[EncodedTextField]=None,
                      sideMultiLegReportingTypeField:Option[SideMultiLegReportingTypeField]=None,
                      noContAmtsField:Option[NoContAmtsField]=None,
                      contAmtsGroups: Option[List[ContAmtsGroup]]=None,
                      stipulationsComponent:Option[StipulationsComponent]=None,
                      noMiscFeesField:Option[NoMiscFeesField]=None,
                      miscFeesGroups: Option[List[MiscFeesGroup]]=None,
                      exchangeRuleField:Option[ExchangeRuleField]=None,
                      tradeAllocIndicatorField:Option[TradeAllocIndicatorField]=None,
                      preallocMethodField:Option[PreallocMethodField]=None,
                      allocIDField:Option[AllocIDField]=None,
                      noAllocsField:Option[NoAllocsField]=None,
                      allocsGroups: Option[List[AllocsGroup]]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {
  if (noClearingInstructionsField.map(_.value).getOrElse(0) != clearingInstructionsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoClearingInstructionsField.TagId,noClearingInstructionsField.map(_.value).getOrElse(0), clearingInstructionsGroups.map(_.size).getOrElse(0))
  if (noContAmtsField.map(_.value).getOrElse(0) != contAmtsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoContAmtsField.TagId,noContAmtsField.map(_.value).getOrElse(0), contAmtsGroups.map(_.size).getOrElse(0))
  if (noMiscFeesField.map(_.value).getOrElse(0) != miscFeesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoMiscFeesField.TagId,noMiscFeesField.map(_.value).getOrElse(0), miscFeesGroups.map(_.size).getOrElse(0))
  if (noAllocsField.map(_.value).getOrElse(0) != allocsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoAllocsField.TagId,noAllocsField.map(_.value).getOrElse(0), allocsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,sideField)
    fmt(b,orderIDField)
    secondaryOrderIDField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    secondaryClOrdIDField.foreach(fmt(b,_))
    listIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    processCodeField.foreach(fmt(b,_))
    oddLotField.foreach(fmt(b,_))
    noClearingInstructionsField.foreach(fmt(b,_))
    clearingInstructionsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    clearingFeeIndicatorField.foreach(fmt(b,_))
    tradeInputSourceField.foreach(fmt(b,_))
    tradeInputDeviceField.foreach(fmt(b,_))
    orderInputDeviceField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    complianceIDField.foreach(fmt(b,_))
    solicitedFlagField.foreach(fmt(b,_))
    orderCapacityField.foreach(fmt(b,_))
    orderRestrictionsField.foreach(fmt(b,_))
    custOrderCapacityField.foreach(fmt(b,_))
    ordTypeField.foreach(fmt(b,_))
    execInstField.foreach(fmt(b,_))
    transBkdTimeField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    timeBracketField.foreach(fmt(b,_))
    commissionDataComponent.foreach(fmt(b,_))
    grossTradeAmtField.foreach(fmt(b,_))
    numDaysInterestField.foreach(fmt(b,_))
    exDateField.foreach(fmt(b,_))
    accruedInterestRateField.foreach(fmt(b,_))
    accruedInterestAmtField.foreach(fmt(b,_))
    interestAtMaturityField.foreach(fmt(b,_))
    endAccruedInterestAmtField.foreach(fmt(b,_))
    startCashField.foreach(fmt(b,_))
    endCashField.foreach(fmt(b,_))
    concessionField.foreach(fmt(b,_))
    totalTakedownField.foreach(fmt(b,_))
    netMoneyField.foreach(fmt(b,_))
    settlCurrAmtField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    settlCurrFxRateField.foreach(fmt(b,_))
    settlCurrFxRateCalcField.foreach(fmt(b,_))
    positionEffectField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    sideMultiLegReportingTypeField.foreach(fmt(b,_))
    noContAmtsField.foreach(fmt(b,_))
    contAmtsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    stipulationsComponent.foreach(fmt(b,_))
    noMiscFeesField.foreach(fmt(b,_))
    miscFeesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    exchangeRuleField.foreach(fmt(b,_))
    tradeAllocIndicatorField.foreach(fmt(b,_))
    preallocMethodField.foreach(fmt(b,_))
    allocIDField.foreach(fmt(b,_))
    noAllocsField.foreach(fmt(b,_))
    allocsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SidesGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int](
    SideField.TagId, OrderIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || ClearingInstructionsGroup.isMandatoryField(tagId) || CommissionDataComponent.isMandatoryField(tagId) || ContAmtsGroup.isMandatoryField(tagId) || 
    StipulationsComponent.isMandatoryField(tagId) || MiscFeesGroup.isMandatoryField(tagId) || AllocsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecondaryOrderIDField.TagId, ClOrdIDField.TagId, SecondaryClOrdIDField.TagId, ListIDField.TagId, AccountField.TagId, 
    AcctIDSourceField.TagId, AccountTypeField.TagId, ProcessCodeField.TagId, OddLotField.TagId, NoClearingInstructionsField.TagId, 
    ClearingFeeIndicatorField.TagId, TradeInputSourceField.TagId, TradeInputDeviceField.TagId, OrderInputDeviceField.TagId, CurrencyField.TagId, 
    ComplianceIDField.TagId, SolicitedFlagField.TagId, OrderCapacityField.TagId, OrderRestrictionsField.TagId, CustOrderCapacityField.TagId, 
    OrdTypeField.TagId, ExecInstField.TagId, TransBkdTimeField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, 
    TimeBracketField.TagId, GrossTradeAmtField.TagId, NumDaysInterestField.TagId, ExDateField.TagId, AccruedInterestRateField.TagId, 
    AccruedInterestAmtField.TagId, InterestAtMaturityField.TagId, EndAccruedInterestAmtField.TagId, StartCashField.TagId, EndCashField.TagId, 
    ConcessionField.TagId, TotalTakedownField.TagId, NetMoneyField.TagId, SettlCurrAmtField.TagId, SettlCurrencyField.TagId, 
    SettlCurrFxRateField.TagId, SettlCurrFxRateCalcField.TagId, PositionEffectField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId, SideMultiLegReportingTypeField.TagId, NoContAmtsField.TagId, NoMiscFeesField.TagId, ExchangeRuleField.TagId, 
    TradeAllocIndicatorField.TagId, PreallocMethodField.TagId, AllocIDField.TagId, NoAllocsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || ClearingInstructionsGroup.isOptionalField(tagId) || CommissionDataComponent.isOptionalField(tagId) || ContAmtsGroup.isOptionalField(tagId) || 
    StipulationsComponent.isOptionalField(tagId) || MiscFeesGroup.isOptionalField(tagId) || AllocsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || ClearingInstructionsGroup.isFieldOf(tagId) || CommissionDataComponent.isFieldOf(tagId) || 
    ContAmtsGroup.isFieldOf(tagId) || StipulationsComponent.isFieldOf(tagId) || MiscFeesGroup.isFieldOf(tagId) || 
    AllocsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoClearingInstructionsField.TagId, NoContAmtsField.TagId, NoMiscFeesField.TagId, NoAllocsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SideField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[SidesGroup]=ArrayBuffer.empty[SidesGroup]):Option[List[SidesGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[SidesGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[SidesGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(SidesGroup(SideField.decode(myFields.get(SideField.TagId)).get,
          OrderIDField.decode(myFields.get(OrderIDField.TagId)).get,
          myFields.get(SecondaryOrderIDField.TagId).flatMap(f=>SecondaryOrderIDField.decode(f)),
          myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
          myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
          myFields.get(ListIDField.TagId).flatMap(f=>ListIDField.decode(f)),
          PartiesComponent.decode(flds, startPos),
          myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
          myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
          myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
          myFields.get(ProcessCodeField.TagId).flatMap(f=>ProcessCodeField.decode(f)),
          myFields.get(OddLotField.TagId).flatMap(f=>OddLotField.decode(f)),
          myFields.get(NoClearingInstructionsField.TagId).flatMap(f=>NoClearingInstructionsField.decode(f)),
          if (nextTagPosLookup.contains(NoClearingInstructionsField.TagId)) ClearingInstructionsGroup.decode(flds, nextTagPosLookup(NoClearingInstructionsField.TagId)) else None,
          myFields.get(ClearingFeeIndicatorField.TagId).flatMap(f=>ClearingFeeIndicatorField.decode(f)),
          myFields.get(TradeInputSourceField.TagId).flatMap(f=>TradeInputSourceField.decode(f)),
          myFields.get(TradeInputDeviceField.TagId).flatMap(f=>TradeInputDeviceField.decode(f)),
          myFields.get(OrderInputDeviceField.TagId).flatMap(f=>OrderInputDeviceField.decode(f)),
          myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
          myFields.get(ComplianceIDField.TagId).flatMap(f=>ComplianceIDField.decode(f)),
          myFields.get(SolicitedFlagField.TagId).flatMap(f=>SolicitedFlagField.decode(f)),
          myFields.get(OrderCapacityField.TagId).flatMap(f=>OrderCapacityField.decode(f)),
          myFields.get(OrderRestrictionsField.TagId).flatMap(f=>OrderRestrictionsField.decode(f)),
          myFields.get(CustOrderCapacityField.TagId).flatMap(f=>CustOrderCapacityField.decode(f)),
          myFields.get(OrdTypeField.TagId).flatMap(f=>OrdTypeField.decode(f)),
          myFields.get(ExecInstField.TagId).flatMap(f=>ExecInstField.decode(f)),
          myFields.get(TransBkdTimeField.TagId).flatMap(f=>TransBkdTimeField.decode(f)),
          myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
          myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
          myFields.get(TimeBracketField.TagId).flatMap(f=>TimeBracketField.decode(f)),
          CommissionDataComponent.decode(flds, startPos),
          myFields.get(GrossTradeAmtField.TagId).flatMap(f=>GrossTradeAmtField.decode(f)),
          myFields.get(NumDaysInterestField.TagId).flatMap(f=>NumDaysInterestField.decode(f)),
          myFields.get(ExDateField.TagId).flatMap(f=>ExDateField.decode(f)),
          myFields.get(AccruedInterestRateField.TagId).flatMap(f=>AccruedInterestRateField.decode(f)),
          myFields.get(AccruedInterestAmtField.TagId).flatMap(f=>AccruedInterestAmtField.decode(f)),
          myFields.get(InterestAtMaturityField.TagId).flatMap(f=>InterestAtMaturityField.decode(f)),
          myFields.get(EndAccruedInterestAmtField.TagId).flatMap(f=>EndAccruedInterestAmtField.decode(f)),
          myFields.get(StartCashField.TagId).flatMap(f=>StartCashField.decode(f)),
          myFields.get(EndCashField.TagId).flatMap(f=>EndCashField.decode(f)),
          myFields.get(ConcessionField.TagId).flatMap(f=>ConcessionField.decode(f)),
          myFields.get(TotalTakedownField.TagId).flatMap(f=>TotalTakedownField.decode(f)),
          myFields.get(NetMoneyField.TagId).flatMap(f=>NetMoneyField.decode(f)),
          myFields.get(SettlCurrAmtField.TagId).flatMap(f=>SettlCurrAmtField.decode(f)),
          myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
          myFields.get(SettlCurrFxRateField.TagId).flatMap(f=>SettlCurrFxRateField.decode(f)),
          myFields.get(SettlCurrFxRateCalcField.TagId).flatMap(f=>SettlCurrFxRateCalcField.decode(f)),
          myFields.get(PositionEffectField.TagId).flatMap(f=>PositionEffectField.decode(f)),
          myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
          myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
          myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
          myFields.get(SideMultiLegReportingTypeField.TagId).flatMap(f=>SideMultiLegReportingTypeField.decode(f)),
          myFields.get(NoContAmtsField.TagId).flatMap(f=>NoContAmtsField.decode(f)),
          if (nextTagPosLookup.contains(NoContAmtsField.TagId)) ContAmtsGroup.decode(flds, nextTagPosLookup(NoContAmtsField.TagId)) else None,
          StipulationsComponent.decode(flds, startPos),
          myFields.get(NoMiscFeesField.TagId).flatMap(f=>NoMiscFeesField.decode(f)),
          if (nextTagPosLookup.contains(NoMiscFeesField.TagId)) MiscFeesGroup.decode(flds, nextTagPosLookup(NoMiscFeesField.TagId)) else None,
          myFields.get(ExchangeRuleField.TagId).flatMap(f=>ExchangeRuleField.decode(f)),
          myFields.get(TradeAllocIndicatorField.TagId).flatMap(f=>TradeAllocIndicatorField.decode(f)),
          myFields.get(PreallocMethodField.TagId).flatMap(f=>PreallocMethodField.decode(f)),
          myFields.get(AllocIDField.TagId).flatMap(f=>AllocIDField.decode(f)),
          myFields.get(NoAllocsField.TagId).flatMap(f=>NoAllocsField.decode(f)),
          if (nextTagPosLookup.contains(NoAllocsField.TagId)) AllocsGroup.decode(flds, nextTagPosLookup(NoAllocsField.TagId)) else None)))
      } else (startPos, None)
    }
  }
    
}
     