package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class DerivativeInstrumentComponent(derivativeSymbolField:Option[DerivativeSymbolField]=None,
                                         derivativeSymbolSfxField:Option[DerivativeSymbolSfxField]=None,
                                         derivativeSecurityIDField:Option[DerivativeSecurityIDField]=None,
                                         derivativeSecurityIDSourceField:Option[DerivativeSecurityIDSourceField]=None,
                                         derivativeSecurityAltIDGrpComponent:Option[DerivativeSecurityAltIDGrpComponent]=None,
                                         derivativeProductField:Option[DerivativeProductField]=None,
                                         derivativeProductComplexField:Option[DerivativeProductComplexField]=None,
                                         derivFlexProductEligibilityIndicatorField:Option[DerivFlexProductEligibilityIndicatorField]=None,
                                         derivativeSecurityGroupField:Option[DerivativeSecurityGroupField]=None,
                                         derivativeCFICodeField:Option[DerivativeCFICodeField]=None,
                                         derivativeSecurityTypeField:Option[DerivativeSecurityTypeField]=None,
                                         derivativeSecuritySubTypeField:Option[DerivativeSecuritySubTypeField]=None,
                                         derivativeMaturityMonthYearField:Option[DerivativeMaturityMonthYearField]=None,
                                         derivativeMaturityDateField:Option[DerivativeMaturityDateField]=None,
                                         derivativeMaturityTimeField:Option[DerivativeMaturityTimeField]=None,
                                         derivativeSettleOnOpenFlagField:Option[DerivativeSettleOnOpenFlagField]=None,
                                         derivativeInstrmtAssignmentMethodField:Option[DerivativeInstrmtAssignmentMethodField]=None,
                                         derivativeSecurityStatusField:Option[DerivativeSecurityStatusField]=None,
                                         derivativeIssueDateField:Option[DerivativeIssueDateField]=None,
                                         derivativeInstrRegistryField:Option[DerivativeInstrRegistryField]=None,
                                         derivativeCountryOfIssueField:Option[DerivativeCountryOfIssueField]=None,
                                         derivativeStateOrProvinceOfIssueField:Option[DerivativeStateOrProvinceOfIssueField]=None,
                                         derivativeLocaleOfIssueField:Option[DerivativeLocaleOfIssueField]=None,
                                         derivativeStrikePriceField:Option[DerivativeStrikePriceField]=None,
                                         derivativeStrikeCurrencyField:Option[DerivativeStrikeCurrencyField]=None,
                                         derivativeStrikeMultiplierField:Option[DerivativeStrikeMultiplierField]=None,
                                         derivativeStrikeValueField:Option[DerivativeStrikeValueField]=None,
                                         derivativeOptAttributeField:Option[DerivativeOptAttributeField]=None,
                                         derivativeContractMultiplierField:Option[DerivativeContractMultiplierField]=None,
                                         derivativeMinPriceIncrementField:Option[DerivativeMinPriceIncrementField]=None,
                                         derivativeMinPriceIncrementAmountField:Option[DerivativeMinPriceIncrementAmountField]=None,
                                         derivativeUnitOfMeasureField:Option[DerivativeUnitOfMeasureField]=None,
                                         derivativeUnitOfMeasureQtyField:Option[DerivativeUnitOfMeasureQtyField]=None,
                                         derivativePriceUnitOfMeasureField:Option[DerivativePriceUnitOfMeasureField]=None,
                                         derivativePriceUnitOfMeasureQtyField:Option[DerivativePriceUnitOfMeasureQtyField]=None,
                                         derivativeSettlMethodField:Option[DerivativeSettlMethodField]=None,
                                         derivativePriceQuoteMethodField:Option[DerivativePriceQuoteMethodField]=None,
                                         derivativeFuturesValuationMethodField:Option[DerivativeFuturesValuationMethodField]=None,
                                         derivativeListMethodField:Option[DerivativeListMethodField]=None,
                                         derivativeCapPriceField:Option[DerivativeCapPriceField]=None,
                                         derivativeFloorPriceField:Option[DerivativeFloorPriceField]=None,
                                         derivativePutOrCallField:Option[DerivativePutOrCallField]=None,
                                         derivativeExerciseStyleField:Option[DerivativeExerciseStyleField]=None,
                                         derivativeOptPayAmountField:Option[DerivativeOptPayAmountField]=None,
                                         derivativeTimeUnitField:Option[DerivativeTimeUnitField]=None,
                                         derivativeSecurityExchangeField:Option[DerivativeSecurityExchangeField]=None,
                                         derivativePositionLimitField:Option[DerivativePositionLimitField]=None,
                                         derivativeNTPositionLimitField:Option[DerivativeNTPositionLimitField]=None,
                                         derivativeIssuerField:Option[DerivativeIssuerField]=None,
                                         derivativeEncodedIssuerLenField:Option[DerivativeEncodedIssuerLenField]=None,
                                         derivativeEncodedIssuerField:Option[DerivativeEncodedIssuerField]=None,
                                         derivativeSecurityDescField:Option[DerivativeSecurityDescField]=None,
                                         derivativeEncodedSecurityDescLenField:Option[DerivativeEncodedSecurityDescLenField]=None,
                                         derivativeEncodedSecurityDescField:Option[DerivativeEncodedSecurityDescField]=None,
                                         derivativeSecurityXMLComponent:Option[DerivativeSecurityXMLComponent]=None,
                                         derivativeContractSettlMonthField:Option[DerivativeContractSettlMonthField]=None,
                                         derivativeEventsGrpComponent:Option[DerivativeEventsGrpComponent]=None,
                                         derivativeInstrumentPartiesComponent:Option[DerivativeInstrumentPartiesComponent]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    derivativeSymbolField.foreach(fmt(b,_))
    derivativeSymbolSfxField.foreach(fmt(b,_))
    derivativeSecurityIDField.foreach(fmt(b,_))
    derivativeSecurityIDSourceField.foreach(fmt(b,_))
    derivativeSecurityAltIDGrpComponent.foreach(fmt(b,_))
    derivativeProductField.foreach(fmt(b,_))
    derivativeProductComplexField.foreach(fmt(b,_))
    derivFlexProductEligibilityIndicatorField.foreach(fmt(b,_))
    derivativeSecurityGroupField.foreach(fmt(b,_))
    derivativeCFICodeField.foreach(fmt(b,_))
    derivativeSecurityTypeField.foreach(fmt(b,_))
    derivativeSecuritySubTypeField.foreach(fmt(b,_))
    derivativeMaturityMonthYearField.foreach(fmt(b,_))
    derivativeMaturityDateField.foreach(fmt(b,_))
    derivativeMaturityTimeField.foreach(fmt(b,_))
    derivativeSettleOnOpenFlagField.foreach(fmt(b,_))
    derivativeInstrmtAssignmentMethodField.foreach(fmt(b,_))
    derivativeSecurityStatusField.foreach(fmt(b,_))
    derivativeIssueDateField.foreach(fmt(b,_))
    derivativeInstrRegistryField.foreach(fmt(b,_))
    derivativeCountryOfIssueField.foreach(fmt(b,_))
    derivativeStateOrProvinceOfIssueField.foreach(fmt(b,_))
    derivativeLocaleOfIssueField.foreach(fmt(b,_))
    derivativeStrikePriceField.foreach(fmt(b,_))
    derivativeStrikeCurrencyField.foreach(fmt(b,_))
    derivativeStrikeMultiplierField.foreach(fmt(b,_))
    derivativeStrikeValueField.foreach(fmt(b,_))
    derivativeOptAttributeField.foreach(fmt(b,_))
    derivativeContractMultiplierField.foreach(fmt(b,_))
    derivativeMinPriceIncrementField.foreach(fmt(b,_))
    derivativeMinPriceIncrementAmountField.foreach(fmt(b,_))
    derivativeUnitOfMeasureField.foreach(fmt(b,_))
    derivativeUnitOfMeasureQtyField.foreach(fmt(b,_))
    derivativePriceUnitOfMeasureField.foreach(fmt(b,_))
    derivativePriceUnitOfMeasureQtyField.foreach(fmt(b,_))
    derivativeSettlMethodField.foreach(fmt(b,_))
    derivativePriceQuoteMethodField.foreach(fmt(b,_))
    derivativeFuturesValuationMethodField.foreach(fmt(b,_))
    derivativeListMethodField.foreach(fmt(b,_))
    derivativeCapPriceField.foreach(fmt(b,_))
    derivativeFloorPriceField.foreach(fmt(b,_))
    derivativePutOrCallField.foreach(fmt(b,_))
    derivativeExerciseStyleField.foreach(fmt(b,_))
    derivativeOptPayAmountField.foreach(fmt(b,_))
    derivativeTimeUnitField.foreach(fmt(b,_))
    derivativeSecurityExchangeField.foreach(fmt(b,_))
    derivativePositionLimitField.foreach(fmt(b,_))
    derivativeNTPositionLimitField.foreach(fmt(b,_))
    derivativeIssuerField.foreach(fmt(b,_))
    derivativeEncodedIssuerLenField.foreach(fmt(b,_))
    derivativeEncodedIssuerField.foreach(fmt(b,_))
    derivativeSecurityDescField.foreach(fmt(b,_))
    derivativeEncodedSecurityDescLenField.foreach(fmt(b,_))
    derivativeEncodedSecurityDescField.foreach(fmt(b,_))
    derivativeSecurityXMLComponent.foreach(fmt(b,_))
    derivativeContractSettlMonthField.foreach(fmt(b,_))
    derivativeEventsGrpComponent.foreach(fmt(b,_))
    derivativeInstrumentPartiesComponent.foreach(fmt(b,_))
    b
  }

}
     
object DerivativeInstrumentComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    DerivativeSecurityAltIDGrpComponent.isMandatoryField(tagId) || DerivativeSecurityXMLComponent.isMandatoryField(tagId) || DerivativeEventsGrpComponent.isMandatoryField(tagId) || DerivativeInstrumentPartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    DerivativeSymbolField.TagId, DerivativeSymbolSfxField.TagId, DerivativeSecurityIDField.TagId, DerivativeSecurityIDSourceField.TagId, DerivativeProductField.TagId, 
    DerivativeProductComplexField.TagId, DerivFlexProductEligibilityIndicatorField.TagId, DerivativeSecurityGroupField.TagId, DerivativeCFICodeField.TagId, DerivativeSecurityTypeField.TagId, 
    DerivativeSecuritySubTypeField.TagId, DerivativeMaturityMonthYearField.TagId, DerivativeMaturityDateField.TagId, DerivativeMaturityTimeField.TagId, DerivativeSettleOnOpenFlagField.TagId, 
    DerivativeInstrmtAssignmentMethodField.TagId, DerivativeSecurityStatusField.TagId, DerivativeIssueDateField.TagId, DerivativeInstrRegistryField.TagId, DerivativeCountryOfIssueField.TagId, 
    DerivativeStateOrProvinceOfIssueField.TagId, DerivativeLocaleOfIssueField.TagId, DerivativeStrikePriceField.TagId, DerivativeStrikeCurrencyField.TagId, DerivativeStrikeMultiplierField.TagId, 
    DerivativeStrikeValueField.TagId, DerivativeOptAttributeField.TagId, DerivativeContractMultiplierField.TagId, DerivativeMinPriceIncrementField.TagId, DerivativeMinPriceIncrementAmountField.TagId, 
    DerivativeUnitOfMeasureField.TagId, DerivativeUnitOfMeasureQtyField.TagId, DerivativePriceUnitOfMeasureField.TagId, DerivativePriceUnitOfMeasureQtyField.TagId, DerivativeSettlMethodField.TagId, 
    DerivativePriceQuoteMethodField.TagId, DerivativeFuturesValuationMethodField.TagId, DerivativeListMethodField.TagId, DerivativeCapPriceField.TagId, DerivativeFloorPriceField.TagId, 
    DerivativePutOrCallField.TagId, DerivativeExerciseStyleField.TagId, DerivativeOptPayAmountField.TagId, DerivativeTimeUnitField.TagId, DerivativeSecurityExchangeField.TagId, 
    DerivativePositionLimitField.TagId, DerivativeNTPositionLimitField.TagId, DerivativeIssuerField.TagId, DerivativeEncodedIssuerLenField.TagId, DerivativeEncodedIssuerField.TagId, 
    DerivativeSecurityDescField.TagId, DerivativeEncodedSecurityDescLenField.TagId, DerivativeEncodedSecurityDescField.TagId, DerivativeContractSettlMonthField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    DerivativeSecurityAltIDGrpComponent.isOptionalField(tagId) || DerivativeSecurityXMLComponent.isOptionalField(tagId) || DerivativeEventsGrpComponent.isOptionalField(tagId) || DerivativeInstrumentPartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    DerivativeSecurityAltIDGrpComponent.isFieldOf(tagId) || DerivativeSecurityXMLComponent.isFieldOf(tagId) || DerivativeEventsGrpComponent.isFieldOf(tagId) || 
    DerivativeInstrumentPartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==DerivativeSymbolField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[DerivativeInstrumentComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(DerivativeInstrumentComponent(myFields.get(DerivativeSymbolField.TagId).flatMap(f=>DerivativeSymbolField.decode(f)),
        myFields.get(DerivativeSymbolSfxField.TagId).flatMap(f=>DerivativeSymbolSfxField.decode(f)),
        myFields.get(DerivativeSecurityIDField.TagId).flatMap(f=>DerivativeSecurityIDField.decode(f)),
        myFields.get(DerivativeSecurityIDSourceField.TagId).flatMap(f=>DerivativeSecurityIDSourceField.decode(f)),
        DerivativeSecurityAltIDGrpComponent.decode(flds, startPos),
        myFields.get(DerivativeProductField.TagId).flatMap(f=>DerivativeProductField.decode(f)),
        myFields.get(DerivativeProductComplexField.TagId).flatMap(f=>DerivativeProductComplexField.decode(f)),
        myFields.get(DerivFlexProductEligibilityIndicatorField.TagId).flatMap(f=>DerivFlexProductEligibilityIndicatorField.decode(f)),
        myFields.get(DerivativeSecurityGroupField.TagId).flatMap(f=>DerivativeSecurityGroupField.decode(f)),
        myFields.get(DerivativeCFICodeField.TagId).flatMap(f=>DerivativeCFICodeField.decode(f)),
        myFields.get(DerivativeSecurityTypeField.TagId).flatMap(f=>DerivativeSecurityTypeField.decode(f)),
        myFields.get(DerivativeSecuritySubTypeField.TagId).flatMap(f=>DerivativeSecuritySubTypeField.decode(f)),
        myFields.get(DerivativeMaturityMonthYearField.TagId).flatMap(f=>DerivativeMaturityMonthYearField.decode(f)),
        myFields.get(DerivativeMaturityDateField.TagId).flatMap(f=>DerivativeMaturityDateField.decode(f)),
        myFields.get(DerivativeMaturityTimeField.TagId).flatMap(f=>DerivativeMaturityTimeField.decode(f)),
        myFields.get(DerivativeSettleOnOpenFlagField.TagId).flatMap(f=>DerivativeSettleOnOpenFlagField.decode(f)),
        myFields.get(DerivativeInstrmtAssignmentMethodField.TagId).flatMap(f=>DerivativeInstrmtAssignmentMethodField.decode(f)),
        myFields.get(DerivativeSecurityStatusField.TagId).flatMap(f=>DerivativeSecurityStatusField.decode(f)),
        myFields.get(DerivativeIssueDateField.TagId).flatMap(f=>DerivativeIssueDateField.decode(f)),
        myFields.get(DerivativeInstrRegistryField.TagId).flatMap(f=>DerivativeInstrRegistryField.decode(f)),
        myFields.get(DerivativeCountryOfIssueField.TagId).flatMap(f=>DerivativeCountryOfIssueField.decode(f)),
        myFields.get(DerivativeStateOrProvinceOfIssueField.TagId).flatMap(f=>DerivativeStateOrProvinceOfIssueField.decode(f)),
        myFields.get(DerivativeLocaleOfIssueField.TagId).flatMap(f=>DerivativeLocaleOfIssueField.decode(f)),
        myFields.get(DerivativeStrikePriceField.TagId).flatMap(f=>DerivativeStrikePriceField.decode(f)),
        myFields.get(DerivativeStrikeCurrencyField.TagId).flatMap(f=>DerivativeStrikeCurrencyField.decode(f)),
        myFields.get(DerivativeStrikeMultiplierField.TagId).flatMap(f=>DerivativeStrikeMultiplierField.decode(f)),
        myFields.get(DerivativeStrikeValueField.TagId).flatMap(f=>DerivativeStrikeValueField.decode(f)),
        myFields.get(DerivativeOptAttributeField.TagId).flatMap(f=>DerivativeOptAttributeField.decode(f)),
        myFields.get(DerivativeContractMultiplierField.TagId).flatMap(f=>DerivativeContractMultiplierField.decode(f)),
        myFields.get(DerivativeMinPriceIncrementField.TagId).flatMap(f=>DerivativeMinPriceIncrementField.decode(f)),
        myFields.get(DerivativeMinPriceIncrementAmountField.TagId).flatMap(f=>DerivativeMinPriceIncrementAmountField.decode(f)),
        myFields.get(DerivativeUnitOfMeasureField.TagId).flatMap(f=>DerivativeUnitOfMeasureField.decode(f)),
        myFields.get(DerivativeUnitOfMeasureQtyField.TagId).flatMap(f=>DerivativeUnitOfMeasureQtyField.decode(f)),
        myFields.get(DerivativePriceUnitOfMeasureField.TagId).flatMap(f=>DerivativePriceUnitOfMeasureField.decode(f)),
        myFields.get(DerivativePriceUnitOfMeasureQtyField.TagId).flatMap(f=>DerivativePriceUnitOfMeasureQtyField.decode(f)),
        myFields.get(DerivativeSettlMethodField.TagId).flatMap(f=>DerivativeSettlMethodField.decode(f)),
        myFields.get(DerivativePriceQuoteMethodField.TagId).flatMap(f=>DerivativePriceQuoteMethodField.decode(f)),
        myFields.get(DerivativeFuturesValuationMethodField.TagId).flatMap(f=>DerivativeFuturesValuationMethodField.decode(f)),
        myFields.get(DerivativeListMethodField.TagId).flatMap(f=>DerivativeListMethodField.decode(f)),
        myFields.get(DerivativeCapPriceField.TagId).flatMap(f=>DerivativeCapPriceField.decode(f)),
        myFields.get(DerivativeFloorPriceField.TagId).flatMap(f=>DerivativeFloorPriceField.decode(f)),
        myFields.get(DerivativePutOrCallField.TagId).flatMap(f=>DerivativePutOrCallField.decode(f)),
        myFields.get(DerivativeExerciseStyleField.TagId).flatMap(f=>DerivativeExerciseStyleField.decode(f)),
        myFields.get(DerivativeOptPayAmountField.TagId).flatMap(f=>DerivativeOptPayAmountField.decode(f)),
        myFields.get(DerivativeTimeUnitField.TagId).flatMap(f=>DerivativeTimeUnitField.decode(f)),
        myFields.get(DerivativeSecurityExchangeField.TagId).flatMap(f=>DerivativeSecurityExchangeField.decode(f)),
        myFields.get(DerivativePositionLimitField.TagId).flatMap(f=>DerivativePositionLimitField.decode(f)),
        myFields.get(DerivativeNTPositionLimitField.TagId).flatMap(f=>DerivativeNTPositionLimitField.decode(f)),
        myFields.get(DerivativeIssuerField.TagId).flatMap(f=>DerivativeIssuerField.decode(f)),
        myFields.get(DerivativeEncodedIssuerLenField.TagId).flatMap(f=>DerivativeEncodedIssuerLenField.decode(f)),
        myFields.get(DerivativeEncodedIssuerField.TagId).flatMap(f=>DerivativeEncodedIssuerField.decode(f)),
        myFields.get(DerivativeSecurityDescField.TagId).flatMap(f=>DerivativeSecurityDescField.decode(f)),
        myFields.get(DerivativeEncodedSecurityDescLenField.TagId).flatMap(f=>DerivativeEncodedSecurityDescLenField.decode(f)),
        myFields.get(DerivativeEncodedSecurityDescField.TagId).flatMap(f=>DerivativeEncodedSecurityDescField.decode(f)),
        DerivativeSecurityXMLComponent.decode(flds, startPos),
        myFields.get(DerivativeContractSettlMonthField.TagId).flatMap(f=>DerivativeContractSettlMonthField.decode(f)),
        DerivativeEventsGrpComponent.decode(flds, startPos),
        DerivativeInstrumentPartiesComponent.decode(flds, startPos)))
    } else None
  }

    
}
     