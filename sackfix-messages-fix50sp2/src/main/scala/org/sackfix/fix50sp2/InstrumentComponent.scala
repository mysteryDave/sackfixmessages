package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class InstrumentComponent(symbolField:Option[SymbolField]=None,
                               symbolSfxField:Option[SymbolSfxField]=None,
                               securityIDField:Option[SecurityIDField]=None,
                               securityIDSourceField:Option[SecurityIDSourceField]=None,
                               secAltIDGrpComponent:Option[SecAltIDGrpComponent]=None,
                               productField:Option[ProductField]=None,
                               productComplexField:Option[ProductComplexField]=None,
                               securityGroupField:Option[SecurityGroupField]=None,
                               cFICodeField:Option[CFICodeField]=None,
                               securityTypeField:Option[SecurityTypeField]=None,
                               securitySubTypeField:Option[SecuritySubTypeField]=None,
                               maturityMonthYearField:Option[MaturityMonthYearField]=None,
                               maturityDateField:Option[MaturityDateField]=None,
                               maturityTimeField:Option[MaturityTimeField]=None,
                               settleOnOpenFlagField:Option[SettleOnOpenFlagField]=None,
                               instrmtAssignmentMethodField:Option[InstrmtAssignmentMethodField]=None,
                               securityStatusField:Option[SecurityStatusField]=None,
                               couponPaymentDateField:Option[CouponPaymentDateField]=None,
                               restructuringTypeField:Option[RestructuringTypeField]=None,
                               seniorityField:Option[SeniorityField]=None,
                               notionalPercentageOutstandingField:Option[NotionalPercentageOutstandingField]=None,
                               originalNotionalPercentageOutstandingField:Option[OriginalNotionalPercentageOutstandingField]=None,
                               attachmentPointField:Option[AttachmentPointField]=None,
                               detachmentPointField:Option[DetachmentPointField]=None,
                               issueDateField:Option[IssueDateField]=None,
                               repoCollateralSecurityTypeField:Option[RepoCollateralSecurityTypeField]=None,
                               repurchaseTermField:Option[RepurchaseTermField]=None,
                               repurchaseRateField:Option[RepurchaseRateField]=None,
                               factorField:Option[FactorField]=None,
                               creditRatingField:Option[CreditRatingField]=None,
                               instrRegistryField:Option[InstrRegistryField]=None,
                               countryOfIssueField:Option[CountryOfIssueField]=None,
                               stateOrProvinceOfIssueField:Option[StateOrProvinceOfIssueField]=None,
                               localeOfIssueField:Option[LocaleOfIssueField]=None,
                               redemptionDateField:Option[RedemptionDateField]=None,
                               strikePriceField:Option[StrikePriceField]=None,
                               strikeCurrencyField:Option[StrikeCurrencyField]=None,
                               strikeMultiplierField:Option[StrikeMultiplierField]=None,
                               strikeValueField:Option[StrikeValueField]=None,
                               strikePriceDeterminationMethodField:Option[StrikePriceDeterminationMethodField]=None,
                               strikePriceBoundaryMethodField:Option[StrikePriceBoundaryMethodField]=None,
                               strikePriceBoundaryPrecisionField:Option[StrikePriceBoundaryPrecisionField]=None,
                               underlyingPriceDeterminationMethodField:Option[UnderlyingPriceDeterminationMethodField]=None,
                               optAttributeField:Option[OptAttributeField]=None,
                               contractMultiplierField:Option[ContractMultiplierField]=None,
                               contractMultiplierUnitField:Option[ContractMultiplierUnitField]=None,
                               flowScheduleTypeField:Option[FlowScheduleTypeField]=None,
                               minPriceIncrementField:Option[MinPriceIncrementField]=None,
                               minPriceIncrementAmountField:Option[MinPriceIncrementAmountField]=None,
                               unitOfMeasureField:Option[UnitOfMeasureField]=None,
                               unitOfMeasureQtyField:Option[UnitOfMeasureQtyField]=None,
                               priceUnitOfMeasureField:Option[PriceUnitOfMeasureField]=None,
                               priceUnitOfMeasureQtyField:Option[PriceUnitOfMeasureQtyField]=None,
                               settlMethodField:Option[SettlMethodField]=None,
                               exerciseStyleField:Option[ExerciseStyleField]=None,
                               optPayoutTypeField:Option[OptPayoutTypeField]=None,
                               optPayoutAmountField:Option[OptPayoutAmountField]=None,
                               priceQuoteMethodField:Option[PriceQuoteMethodField]=None,
                               valuationMethodField:Option[ValuationMethodField]=None,
                               listMethodField:Option[ListMethodField]=None,
                               capPriceField:Option[CapPriceField]=None,
                               floorPriceField:Option[FloorPriceField]=None,
                               putOrCallField:Option[PutOrCallField]=None,
                               flexibleIndicatorField:Option[FlexibleIndicatorField]=None,
                               flexProductEligibilityIndicatorField:Option[FlexProductEligibilityIndicatorField]=None,
                               timeUnitField:Option[TimeUnitField]=None,
                               couponRateField:Option[CouponRateField]=None,
                               securityExchangeField:Option[SecurityExchangeField]=None,
                               positionLimitField:Option[PositionLimitField]=None,
                               nTPositionLimitField:Option[NTPositionLimitField]=None,
                               issuerField:Option[IssuerField]=None,
                               encodedIssuerLenField:Option[EncodedIssuerLenField]=None,
                               encodedIssuerField:Option[EncodedIssuerField]=None,
                               securityDescField:Option[SecurityDescField]=None,
                               encodedSecurityDescLenField:Option[EncodedSecurityDescLenField]=None,
                               encodedSecurityDescField:Option[EncodedSecurityDescField]=None,
                               securityXMLComponent:Option[SecurityXMLComponent]=None,
                               poolField:Option[PoolField]=None,
                               contractSettlMonthField:Option[ContractSettlMonthField]=None,
                               cPProgramField:Option[CPProgramField]=None,
                               cPRegTypeField:Option[CPRegTypeField]=None,
                               evntGrpComponent:Option[EvntGrpComponent]=None,
                               datedDateField:Option[DatedDateField]=None,
                               interestAccrualDateField:Option[InterestAccrualDateField]=None,
                               instrumentPartiesComponent:Option[InstrumentPartiesComponent]=None,
                               complexEventsComponent:Option[ComplexEventsComponent]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    symbolField.foreach(fmt(b,_))
    symbolSfxField.foreach(fmt(b,_))
    securityIDField.foreach(fmt(b,_))
    securityIDSourceField.foreach(fmt(b,_))
    secAltIDGrpComponent.foreach(fmt(b,_))
    productField.foreach(fmt(b,_))
    productComplexField.foreach(fmt(b,_))
    securityGroupField.foreach(fmt(b,_))
    cFICodeField.foreach(fmt(b,_))
    securityTypeField.foreach(fmt(b,_))
    securitySubTypeField.foreach(fmt(b,_))
    maturityMonthYearField.foreach(fmt(b,_))
    maturityDateField.foreach(fmt(b,_))
    maturityTimeField.foreach(fmt(b,_))
    settleOnOpenFlagField.foreach(fmt(b,_))
    instrmtAssignmentMethodField.foreach(fmt(b,_))
    securityStatusField.foreach(fmt(b,_))
    couponPaymentDateField.foreach(fmt(b,_))
    restructuringTypeField.foreach(fmt(b,_))
    seniorityField.foreach(fmt(b,_))
    notionalPercentageOutstandingField.foreach(fmt(b,_))
    originalNotionalPercentageOutstandingField.foreach(fmt(b,_))
    attachmentPointField.foreach(fmt(b,_))
    detachmentPointField.foreach(fmt(b,_))
    issueDateField.foreach(fmt(b,_))
    repoCollateralSecurityTypeField.foreach(fmt(b,_))
    repurchaseTermField.foreach(fmt(b,_))
    repurchaseRateField.foreach(fmt(b,_))
    factorField.foreach(fmt(b,_))
    creditRatingField.foreach(fmt(b,_))
    instrRegistryField.foreach(fmt(b,_))
    countryOfIssueField.foreach(fmt(b,_))
    stateOrProvinceOfIssueField.foreach(fmt(b,_))
    localeOfIssueField.foreach(fmt(b,_))
    redemptionDateField.foreach(fmt(b,_))
    strikePriceField.foreach(fmt(b,_))
    strikeCurrencyField.foreach(fmt(b,_))
    strikeMultiplierField.foreach(fmt(b,_))
    strikeValueField.foreach(fmt(b,_))
    strikePriceDeterminationMethodField.foreach(fmt(b,_))
    strikePriceBoundaryMethodField.foreach(fmt(b,_))
    strikePriceBoundaryPrecisionField.foreach(fmt(b,_))
    underlyingPriceDeterminationMethodField.foreach(fmt(b,_))
    optAttributeField.foreach(fmt(b,_))
    contractMultiplierField.foreach(fmt(b,_))
    contractMultiplierUnitField.foreach(fmt(b,_))
    flowScheduleTypeField.foreach(fmt(b,_))
    minPriceIncrementField.foreach(fmt(b,_))
    minPriceIncrementAmountField.foreach(fmt(b,_))
    unitOfMeasureField.foreach(fmt(b,_))
    unitOfMeasureQtyField.foreach(fmt(b,_))
    priceUnitOfMeasureField.foreach(fmt(b,_))
    priceUnitOfMeasureQtyField.foreach(fmt(b,_))
    settlMethodField.foreach(fmt(b,_))
    exerciseStyleField.foreach(fmt(b,_))
    optPayoutTypeField.foreach(fmt(b,_))
    optPayoutAmountField.foreach(fmt(b,_))
    priceQuoteMethodField.foreach(fmt(b,_))
    valuationMethodField.foreach(fmt(b,_))
    listMethodField.foreach(fmt(b,_))
    capPriceField.foreach(fmt(b,_))
    floorPriceField.foreach(fmt(b,_))
    putOrCallField.foreach(fmt(b,_))
    flexibleIndicatorField.foreach(fmt(b,_))
    flexProductEligibilityIndicatorField.foreach(fmt(b,_))
    timeUnitField.foreach(fmt(b,_))
    couponRateField.foreach(fmt(b,_))
    securityExchangeField.foreach(fmt(b,_))
    positionLimitField.foreach(fmt(b,_))
    nTPositionLimitField.foreach(fmt(b,_))
    issuerField.foreach(fmt(b,_))
    encodedIssuerLenField.foreach(fmt(b,_))
    encodedIssuerField.foreach(fmt(b,_))
    securityDescField.foreach(fmt(b,_))
    encodedSecurityDescLenField.foreach(fmt(b,_))
    encodedSecurityDescField.foreach(fmt(b,_))
    securityXMLComponent.foreach(fmt(b,_))
    poolField.foreach(fmt(b,_))
    contractSettlMonthField.foreach(fmt(b,_))
    cPProgramField.foreach(fmt(b,_))
    cPRegTypeField.foreach(fmt(b,_))
    evntGrpComponent.foreach(fmt(b,_))
    datedDateField.foreach(fmt(b,_))
    interestAccrualDateField.foreach(fmt(b,_))
    instrumentPartiesComponent.foreach(fmt(b,_))
    complexEventsComponent.foreach(fmt(b,_))
    b
  }

}
     
object InstrumentComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SecAltIDGrpComponent.isMandatoryField(tagId) || SecurityXMLComponent.isMandatoryField(tagId) || EvntGrpComponent.isMandatoryField(tagId) || InstrumentPartiesComponent.isMandatoryField(tagId) || 
    ComplexEventsComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SymbolField.TagId, SymbolSfxField.TagId, SecurityIDField.TagId, SecurityIDSourceField.TagId, ProductField.TagId, 
    ProductComplexField.TagId, SecurityGroupField.TagId, CFICodeField.TagId, SecurityTypeField.TagId, SecuritySubTypeField.TagId, 
    MaturityMonthYearField.TagId, MaturityDateField.TagId, MaturityTimeField.TagId, SettleOnOpenFlagField.TagId, InstrmtAssignmentMethodField.TagId, 
    SecurityStatusField.TagId, CouponPaymentDateField.TagId, RestructuringTypeField.TagId, SeniorityField.TagId, NotionalPercentageOutstandingField.TagId, 
    OriginalNotionalPercentageOutstandingField.TagId, AttachmentPointField.TagId, DetachmentPointField.TagId, IssueDateField.TagId, RepoCollateralSecurityTypeField.TagId, 
    RepurchaseTermField.TagId, RepurchaseRateField.TagId, FactorField.TagId, CreditRatingField.TagId, InstrRegistryField.TagId, 
    CountryOfIssueField.TagId, StateOrProvinceOfIssueField.TagId, LocaleOfIssueField.TagId, RedemptionDateField.TagId, StrikePriceField.TagId, 
    StrikeCurrencyField.TagId, StrikeMultiplierField.TagId, StrikeValueField.TagId, StrikePriceDeterminationMethodField.TagId, StrikePriceBoundaryMethodField.TagId, 
    StrikePriceBoundaryPrecisionField.TagId, UnderlyingPriceDeterminationMethodField.TagId, OptAttributeField.TagId, ContractMultiplierField.TagId, ContractMultiplierUnitField.TagId, 
    FlowScheduleTypeField.TagId, MinPriceIncrementField.TagId, MinPriceIncrementAmountField.TagId, UnitOfMeasureField.TagId, UnitOfMeasureQtyField.TagId, 
    PriceUnitOfMeasureField.TagId, PriceUnitOfMeasureQtyField.TagId, SettlMethodField.TagId, ExerciseStyleField.TagId, OptPayoutTypeField.TagId, 
    OptPayoutAmountField.TagId, PriceQuoteMethodField.TagId, ValuationMethodField.TagId, ListMethodField.TagId, CapPriceField.TagId, 
    FloorPriceField.TagId, PutOrCallField.TagId, FlexibleIndicatorField.TagId, FlexProductEligibilityIndicatorField.TagId, TimeUnitField.TagId, 
    CouponRateField.TagId, SecurityExchangeField.TagId, PositionLimitField.TagId, NTPositionLimitField.TagId, IssuerField.TagId, 
    EncodedIssuerLenField.TagId, EncodedIssuerField.TagId, SecurityDescField.TagId, EncodedSecurityDescLenField.TagId, EncodedSecurityDescField.TagId, 
    PoolField.TagId, ContractSettlMonthField.TagId, CPProgramField.TagId, CPRegTypeField.TagId, DatedDateField.TagId, 
    InterestAccrualDateField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SecAltIDGrpComponent.isOptionalField(tagId) || SecurityXMLComponent.isOptionalField(tagId) || EvntGrpComponent.isOptionalField(tagId) || InstrumentPartiesComponent.isOptionalField(tagId) || 
    ComplexEventsComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SecAltIDGrpComponent.isFieldOf(tagId) || SecurityXMLComponent.isFieldOf(tagId) || EvntGrpComponent.isFieldOf(tagId) || 
    InstrumentPartiesComponent.isFieldOf(tagId) || ComplexEventsComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SymbolField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[InstrumentComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(InstrumentComponent(myFields.get(SymbolField.TagId).flatMap(f=>SymbolField.decode(f)),
        myFields.get(SymbolSfxField.TagId).flatMap(f=>SymbolSfxField.decode(f)),
        myFields.get(SecurityIDField.TagId).flatMap(f=>SecurityIDField.decode(f)),
        myFields.get(SecurityIDSourceField.TagId).flatMap(f=>SecurityIDSourceField.decode(f)),
        SecAltIDGrpComponent.decode(flds, startPos),
        myFields.get(ProductField.TagId).flatMap(f=>ProductField.decode(f)),
        myFields.get(ProductComplexField.TagId).flatMap(f=>ProductComplexField.decode(f)),
        myFields.get(SecurityGroupField.TagId).flatMap(f=>SecurityGroupField.decode(f)),
        myFields.get(CFICodeField.TagId).flatMap(f=>CFICodeField.decode(f)),
        myFields.get(SecurityTypeField.TagId).flatMap(f=>SecurityTypeField.decode(f)),
        myFields.get(SecuritySubTypeField.TagId).flatMap(f=>SecuritySubTypeField.decode(f)),
        myFields.get(MaturityMonthYearField.TagId).flatMap(f=>MaturityMonthYearField.decode(f)),
        myFields.get(MaturityDateField.TagId).flatMap(f=>MaturityDateField.decode(f)),
        myFields.get(MaturityTimeField.TagId).flatMap(f=>MaturityTimeField.decode(f)),
        myFields.get(SettleOnOpenFlagField.TagId).flatMap(f=>SettleOnOpenFlagField.decode(f)),
        myFields.get(InstrmtAssignmentMethodField.TagId).flatMap(f=>InstrmtAssignmentMethodField.decode(f)),
        myFields.get(SecurityStatusField.TagId).flatMap(f=>SecurityStatusField.decode(f)),
        myFields.get(CouponPaymentDateField.TagId).flatMap(f=>CouponPaymentDateField.decode(f)),
        myFields.get(RestructuringTypeField.TagId).flatMap(f=>RestructuringTypeField.decode(f)),
        myFields.get(SeniorityField.TagId).flatMap(f=>SeniorityField.decode(f)),
        myFields.get(NotionalPercentageOutstandingField.TagId).flatMap(f=>NotionalPercentageOutstandingField.decode(f)),
        myFields.get(OriginalNotionalPercentageOutstandingField.TagId).flatMap(f=>OriginalNotionalPercentageOutstandingField.decode(f)),
        myFields.get(AttachmentPointField.TagId).flatMap(f=>AttachmentPointField.decode(f)),
        myFields.get(DetachmentPointField.TagId).flatMap(f=>DetachmentPointField.decode(f)),
        myFields.get(IssueDateField.TagId).flatMap(f=>IssueDateField.decode(f)),
        myFields.get(RepoCollateralSecurityTypeField.TagId).flatMap(f=>RepoCollateralSecurityTypeField.decode(f)),
        myFields.get(RepurchaseTermField.TagId).flatMap(f=>RepurchaseTermField.decode(f)),
        myFields.get(RepurchaseRateField.TagId).flatMap(f=>RepurchaseRateField.decode(f)),
        myFields.get(FactorField.TagId).flatMap(f=>FactorField.decode(f)),
        myFields.get(CreditRatingField.TagId).flatMap(f=>CreditRatingField.decode(f)),
        myFields.get(InstrRegistryField.TagId).flatMap(f=>InstrRegistryField.decode(f)),
        myFields.get(CountryOfIssueField.TagId).flatMap(f=>CountryOfIssueField.decode(f)),
        myFields.get(StateOrProvinceOfIssueField.TagId).flatMap(f=>StateOrProvinceOfIssueField.decode(f)),
        myFields.get(LocaleOfIssueField.TagId).flatMap(f=>LocaleOfIssueField.decode(f)),
        myFields.get(RedemptionDateField.TagId).flatMap(f=>RedemptionDateField.decode(f)),
        myFields.get(StrikePriceField.TagId).flatMap(f=>StrikePriceField.decode(f)),
        myFields.get(StrikeCurrencyField.TagId).flatMap(f=>StrikeCurrencyField.decode(f)),
        myFields.get(StrikeMultiplierField.TagId).flatMap(f=>StrikeMultiplierField.decode(f)),
        myFields.get(StrikeValueField.TagId).flatMap(f=>StrikeValueField.decode(f)),
        myFields.get(StrikePriceDeterminationMethodField.TagId).flatMap(f=>StrikePriceDeterminationMethodField.decode(f)),
        myFields.get(StrikePriceBoundaryMethodField.TagId).flatMap(f=>StrikePriceBoundaryMethodField.decode(f)),
        myFields.get(StrikePriceBoundaryPrecisionField.TagId).flatMap(f=>StrikePriceBoundaryPrecisionField.decode(f)),
        myFields.get(UnderlyingPriceDeterminationMethodField.TagId).flatMap(f=>UnderlyingPriceDeterminationMethodField.decode(f)),
        myFields.get(OptAttributeField.TagId).flatMap(f=>OptAttributeField.decode(f)),
        myFields.get(ContractMultiplierField.TagId).flatMap(f=>ContractMultiplierField.decode(f)),
        myFields.get(ContractMultiplierUnitField.TagId).flatMap(f=>ContractMultiplierUnitField.decode(f)),
        myFields.get(FlowScheduleTypeField.TagId).flatMap(f=>FlowScheduleTypeField.decode(f)),
        myFields.get(MinPriceIncrementField.TagId).flatMap(f=>MinPriceIncrementField.decode(f)),
        myFields.get(MinPriceIncrementAmountField.TagId).flatMap(f=>MinPriceIncrementAmountField.decode(f)),
        myFields.get(UnitOfMeasureField.TagId).flatMap(f=>UnitOfMeasureField.decode(f)),
        myFields.get(UnitOfMeasureQtyField.TagId).flatMap(f=>UnitOfMeasureQtyField.decode(f)),
        myFields.get(PriceUnitOfMeasureField.TagId).flatMap(f=>PriceUnitOfMeasureField.decode(f)),
        myFields.get(PriceUnitOfMeasureQtyField.TagId).flatMap(f=>PriceUnitOfMeasureQtyField.decode(f)),
        myFields.get(SettlMethodField.TagId).flatMap(f=>SettlMethodField.decode(f)),
        myFields.get(ExerciseStyleField.TagId).flatMap(f=>ExerciseStyleField.decode(f)),
        myFields.get(OptPayoutTypeField.TagId).flatMap(f=>OptPayoutTypeField.decode(f)),
        myFields.get(OptPayoutAmountField.TagId).flatMap(f=>OptPayoutAmountField.decode(f)),
        myFields.get(PriceQuoteMethodField.TagId).flatMap(f=>PriceQuoteMethodField.decode(f)),
        myFields.get(ValuationMethodField.TagId).flatMap(f=>ValuationMethodField.decode(f)),
        myFields.get(ListMethodField.TagId).flatMap(f=>ListMethodField.decode(f)),
        myFields.get(CapPriceField.TagId).flatMap(f=>CapPriceField.decode(f)),
        myFields.get(FloorPriceField.TagId).flatMap(f=>FloorPriceField.decode(f)),
        myFields.get(PutOrCallField.TagId).flatMap(f=>PutOrCallField.decode(f)),
        myFields.get(FlexibleIndicatorField.TagId).flatMap(f=>FlexibleIndicatorField.decode(f)),
        myFields.get(FlexProductEligibilityIndicatorField.TagId).flatMap(f=>FlexProductEligibilityIndicatorField.decode(f)),
        myFields.get(TimeUnitField.TagId).flatMap(f=>TimeUnitField.decode(f)),
        myFields.get(CouponRateField.TagId).flatMap(f=>CouponRateField.decode(f)),
        myFields.get(SecurityExchangeField.TagId).flatMap(f=>SecurityExchangeField.decode(f)),
        myFields.get(PositionLimitField.TagId).flatMap(f=>PositionLimitField.decode(f)),
        myFields.get(NTPositionLimitField.TagId).flatMap(f=>NTPositionLimitField.decode(f)),
        myFields.get(IssuerField.TagId).flatMap(f=>IssuerField.decode(f)),
        myFields.get(EncodedIssuerLenField.TagId).flatMap(f=>EncodedIssuerLenField.decode(f)),
        myFields.get(EncodedIssuerField.TagId).flatMap(f=>EncodedIssuerField.decode(f)),
        myFields.get(SecurityDescField.TagId).flatMap(f=>SecurityDescField.decode(f)),
        myFields.get(EncodedSecurityDescLenField.TagId).flatMap(f=>EncodedSecurityDescLenField.decode(f)),
        myFields.get(EncodedSecurityDescField.TagId).flatMap(f=>EncodedSecurityDescField.decode(f)),
        SecurityXMLComponent.decode(flds, startPos),
        myFields.get(PoolField.TagId).flatMap(f=>PoolField.decode(f)),
        myFields.get(ContractSettlMonthField.TagId).flatMap(f=>ContractSettlMonthField.decode(f)),
        myFields.get(CPProgramField.TagId).flatMap(f=>CPProgramField.decode(f)),
        myFields.get(CPRegTypeField.TagId).flatMap(f=>CPRegTypeField.decode(f)),
        EvntGrpComponent.decode(flds, startPos),
        myFields.get(DatedDateField.TagId).flatMap(f=>DatedDateField.decode(f)),
        myFields.get(InterestAccrualDateField.TagId).flatMap(f=>InterestAccrualDateField.decode(f)),
        InstrumentPartiesComponent.decode(flds, startPos),
        ComplexEventsComponent.decode(flds, startPos)))
    } else None
  }

    
}
     