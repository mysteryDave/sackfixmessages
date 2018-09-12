package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class UnderlyingInstrumentComponent(underlyingSymbolField:UnderlyingSymbolField,
                                         underlyingSymbolSfxField:Option[UnderlyingSymbolSfxField]=None,
                                         underlyingSecurityIDField:Option[UnderlyingSecurityIDField]=None,
                                         underlyingSecurityIDSourceField:Option[UnderlyingSecurityIDSourceField]=None,
                                         noUnderlyingSecurityAltIDField:Option[NoUnderlyingSecurityAltIDField]=None,
                                         underlyingSecurityAltIDGroups: Option[List[UnderlyingSecurityAltIDGroup]]=None,
                                         underlyingProductField:Option[UnderlyingProductField]=None,
                                         underlyingCFICodeField:Option[UnderlyingCFICodeField]=None,
                                         underlyingSecurityTypeField:Option[UnderlyingSecurityTypeField]=None,
                                         underlyingSecuritySubTypeField:Option[UnderlyingSecuritySubTypeField]=None,
                                         underlyingMaturityMonthYearField:Option[UnderlyingMaturityMonthYearField]=None,
                                         underlyingMaturityDateField:Option[UnderlyingMaturityDateField]=None,
                                         underlyingPutOrCallField:Option[UnderlyingPutOrCallField]=None,
                                         underlyingCouponPaymentDateField:Option[UnderlyingCouponPaymentDateField]=None,
                                         underlyingIssueDateField:Option[UnderlyingIssueDateField]=None,
                                         underlyingRepoCollateralSecurityTypeField:Option[UnderlyingRepoCollateralSecurityTypeField]=None,
                                         underlyingRepurchaseTermField:Option[UnderlyingRepurchaseTermField]=None,
                                         underlyingRepurchaseRateField:Option[UnderlyingRepurchaseRateField]=None,
                                         underlyingFactorField:Option[UnderlyingFactorField]=None,
                                         underlyingCreditRatingField:Option[UnderlyingCreditRatingField]=None,
                                         underlyingInstrRegistryField:Option[UnderlyingInstrRegistryField]=None,
                                         underlyingCountryOfIssueField:Option[UnderlyingCountryOfIssueField]=None,
                                         underlyingStateOrProvinceOfIssueField:Option[UnderlyingStateOrProvinceOfIssueField]=None,
                                         underlyingLocaleOfIssueField:Option[UnderlyingLocaleOfIssueField]=None,
                                         underlyingRedemptionDateField:Option[UnderlyingRedemptionDateField]=None,
                                         underlyingStrikePriceField:Option[UnderlyingStrikePriceField]=None,
                                         underlyingStrikeCurrencyField:Option[UnderlyingStrikeCurrencyField]=None,
                                         underlyingOptAttributeField:Option[UnderlyingOptAttributeField]=None,
                                         underlyingContractMultiplierField:Option[UnderlyingContractMultiplierField]=None,
                                         underlyingCouponRateField:Option[UnderlyingCouponRateField]=None,
                                         underlyingSecurityExchangeField:Option[UnderlyingSecurityExchangeField]=None,
                                         underlyingIssuerField:Option[UnderlyingIssuerField]=None,
                                         encodedUnderlyingIssuerLenField:Option[EncodedUnderlyingIssuerLenField]=None,
                                         encodedUnderlyingIssuerField:Option[EncodedUnderlyingIssuerField]=None,
                                         underlyingSecurityDescField:Option[UnderlyingSecurityDescField]=None,
                                         encodedUnderlyingSecurityDescLenField:Option[EncodedUnderlyingSecurityDescLenField]=None,
                                         encodedUnderlyingSecurityDescField:Option[EncodedUnderlyingSecurityDescField]=None,
                                         underlyingCPProgramField:Option[UnderlyingCPProgramField]=None,
                                         underlyingCPRegTypeField:Option[UnderlyingCPRegTypeField]=None,
                                         underlyingCurrencyField:Option[UnderlyingCurrencyField]=None,
                                         underlyingQtyField:Option[UnderlyingQtyField]=None,
                                         underlyingPxField:Option[UnderlyingPxField]=None,
                                         underlyingDirtyPriceField:Option[UnderlyingDirtyPriceField]=None,
                                         underlyingEndPriceField:Option[UnderlyingEndPriceField]=None,
                                         underlyingStartValueField:Option[UnderlyingStartValueField]=None,
                                         underlyingCurrentValueField:Option[UnderlyingCurrentValueField]=None,
                                         underlyingEndValueField:Option[UnderlyingEndValueField]=None,
                                         underlyingStipulationsComponent:Option[UnderlyingStipulationsComponent]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUnderlyingSecurityAltIDField.map(_.value).getOrElse(0) != underlyingSecurityAltIDGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingSecurityAltIDField.TagId,noUnderlyingSecurityAltIDField.map(_.value).getOrElse(0), underlyingSecurityAltIDGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,underlyingSymbolField)
    underlyingSymbolSfxField.foreach(fmt(b,_))
    underlyingSecurityIDField.foreach(fmt(b,_))
    underlyingSecurityIDSourceField.foreach(fmt(b,_))
    noUnderlyingSecurityAltIDField.foreach(fmt(b,_))
    underlyingSecurityAltIDGroups.getOrElse(List.empty).foreach(fmt(b,_))
    underlyingProductField.foreach(fmt(b,_))
    underlyingCFICodeField.foreach(fmt(b,_))
    underlyingSecurityTypeField.foreach(fmt(b,_))
    underlyingSecuritySubTypeField.foreach(fmt(b,_))
    underlyingMaturityMonthYearField.foreach(fmt(b,_))
    underlyingMaturityDateField.foreach(fmt(b,_))
    underlyingPutOrCallField.foreach(fmt(b,_))
    underlyingCouponPaymentDateField.foreach(fmt(b,_))
    underlyingIssueDateField.foreach(fmt(b,_))
    underlyingRepoCollateralSecurityTypeField.foreach(fmt(b,_))
    underlyingRepurchaseTermField.foreach(fmt(b,_))
    underlyingRepurchaseRateField.foreach(fmt(b,_))
    underlyingFactorField.foreach(fmt(b,_))
    underlyingCreditRatingField.foreach(fmt(b,_))
    underlyingInstrRegistryField.foreach(fmt(b,_))
    underlyingCountryOfIssueField.foreach(fmt(b,_))
    underlyingStateOrProvinceOfIssueField.foreach(fmt(b,_))
    underlyingLocaleOfIssueField.foreach(fmt(b,_))
    underlyingRedemptionDateField.foreach(fmt(b,_))
    underlyingStrikePriceField.foreach(fmt(b,_))
    underlyingStrikeCurrencyField.foreach(fmt(b,_))
    underlyingOptAttributeField.foreach(fmt(b,_))
    underlyingContractMultiplierField.foreach(fmt(b,_))
    underlyingCouponRateField.foreach(fmt(b,_))
    underlyingSecurityExchangeField.foreach(fmt(b,_))
    underlyingIssuerField.foreach(fmt(b,_))
    encodedUnderlyingIssuerLenField.foreach(fmt(b,_))
    encodedUnderlyingIssuerField.foreach(fmt(b,_))
    underlyingSecurityDescField.foreach(fmt(b,_))
    encodedUnderlyingSecurityDescLenField.foreach(fmt(b,_))
    encodedUnderlyingSecurityDescField.foreach(fmt(b,_))
    underlyingCPProgramField.foreach(fmt(b,_))
    underlyingCPRegTypeField.foreach(fmt(b,_))
    underlyingCurrencyField.foreach(fmt(b,_))
    underlyingQtyField.foreach(fmt(b,_))
    underlyingPxField.foreach(fmt(b,_))
    underlyingDirtyPriceField.foreach(fmt(b,_))
    underlyingEndPriceField.foreach(fmt(b,_))
    underlyingStartValueField.foreach(fmt(b,_))
    underlyingCurrentValueField.foreach(fmt(b,_))
    underlyingEndValueField.foreach(fmt(b,_))
    underlyingStipulationsComponent.foreach(fmt(b,_))
    b
  }

}
     
object UnderlyingInstrumentComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    UnderlyingSymbolField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    UnderlyingSecurityAltIDGroup.isMandatoryField(tagId) || UnderlyingStipulationsComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    UnderlyingSymbolSfxField.TagId, UnderlyingSecurityIDField.TagId, UnderlyingSecurityIDSourceField.TagId, NoUnderlyingSecurityAltIDField.TagId, UnderlyingProductField.TagId, 
    UnderlyingCFICodeField.TagId, UnderlyingSecurityTypeField.TagId, UnderlyingSecuritySubTypeField.TagId, UnderlyingMaturityMonthYearField.TagId, UnderlyingMaturityDateField.TagId, 
    UnderlyingPutOrCallField.TagId, UnderlyingCouponPaymentDateField.TagId, UnderlyingIssueDateField.TagId, UnderlyingRepoCollateralSecurityTypeField.TagId, UnderlyingRepurchaseTermField.TagId, 
    UnderlyingRepurchaseRateField.TagId, UnderlyingFactorField.TagId, UnderlyingCreditRatingField.TagId, UnderlyingInstrRegistryField.TagId, UnderlyingCountryOfIssueField.TagId, 
    UnderlyingStateOrProvinceOfIssueField.TagId, UnderlyingLocaleOfIssueField.TagId, UnderlyingRedemptionDateField.TagId, UnderlyingStrikePriceField.TagId, UnderlyingStrikeCurrencyField.TagId, 
    UnderlyingOptAttributeField.TagId, UnderlyingContractMultiplierField.TagId, UnderlyingCouponRateField.TagId, UnderlyingSecurityExchangeField.TagId, UnderlyingIssuerField.TagId, 
    EncodedUnderlyingIssuerLenField.TagId, EncodedUnderlyingIssuerField.TagId, UnderlyingSecurityDescField.TagId, EncodedUnderlyingSecurityDescLenField.TagId, EncodedUnderlyingSecurityDescField.TagId, 
    UnderlyingCPProgramField.TagId, UnderlyingCPRegTypeField.TagId, UnderlyingCurrencyField.TagId, UnderlyingQtyField.TagId, UnderlyingPxField.TagId, 
    UnderlyingDirtyPriceField.TagId, UnderlyingEndPriceField.TagId, UnderlyingStartValueField.TagId, UnderlyingCurrentValueField.TagId, UnderlyingEndValueField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    UnderlyingSecurityAltIDGroup.isOptionalField(tagId) || UnderlyingStipulationsComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    UnderlyingSecurityAltIDGroup.isFieldOf(tagId) || UnderlyingStipulationsComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUnderlyingSecurityAltIDField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==UnderlyingSymbolField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[UnderlyingInstrumentComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(UnderlyingInstrumentComponent(UnderlyingSymbolField.decode(myFields.get(UnderlyingSymbolField.TagId)).get,
        myFields.get(UnderlyingSymbolSfxField.TagId).flatMap(f=>UnderlyingSymbolSfxField.decode(f)),
        myFields.get(UnderlyingSecurityIDField.TagId).flatMap(f=>UnderlyingSecurityIDField.decode(f)),
        myFields.get(UnderlyingSecurityIDSourceField.TagId).flatMap(f=>UnderlyingSecurityIDSourceField.decode(f)),
        myFields.get(NoUnderlyingSecurityAltIDField.TagId).flatMap(f=>NoUnderlyingSecurityAltIDField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingSecurityAltIDField.TagId)) UnderlyingSecurityAltIDGroup.decode(flds, nextTagPosLookup(NoUnderlyingSecurityAltIDField.TagId)) else None,
        myFields.get(UnderlyingProductField.TagId).flatMap(f=>UnderlyingProductField.decode(f)),
        myFields.get(UnderlyingCFICodeField.TagId).flatMap(f=>UnderlyingCFICodeField.decode(f)),
        myFields.get(UnderlyingSecurityTypeField.TagId).flatMap(f=>UnderlyingSecurityTypeField.decode(f)),
        myFields.get(UnderlyingSecuritySubTypeField.TagId).flatMap(f=>UnderlyingSecuritySubTypeField.decode(f)),
        myFields.get(UnderlyingMaturityMonthYearField.TagId).flatMap(f=>UnderlyingMaturityMonthYearField.decode(f)),
        myFields.get(UnderlyingMaturityDateField.TagId).flatMap(f=>UnderlyingMaturityDateField.decode(f)),
        myFields.get(UnderlyingPutOrCallField.TagId).flatMap(f=>UnderlyingPutOrCallField.decode(f)),
        myFields.get(UnderlyingCouponPaymentDateField.TagId).flatMap(f=>UnderlyingCouponPaymentDateField.decode(f)),
        myFields.get(UnderlyingIssueDateField.TagId).flatMap(f=>UnderlyingIssueDateField.decode(f)),
        myFields.get(UnderlyingRepoCollateralSecurityTypeField.TagId).flatMap(f=>UnderlyingRepoCollateralSecurityTypeField.decode(f)),
        myFields.get(UnderlyingRepurchaseTermField.TagId).flatMap(f=>UnderlyingRepurchaseTermField.decode(f)),
        myFields.get(UnderlyingRepurchaseRateField.TagId).flatMap(f=>UnderlyingRepurchaseRateField.decode(f)),
        myFields.get(UnderlyingFactorField.TagId).flatMap(f=>UnderlyingFactorField.decode(f)),
        myFields.get(UnderlyingCreditRatingField.TagId).flatMap(f=>UnderlyingCreditRatingField.decode(f)),
        myFields.get(UnderlyingInstrRegistryField.TagId).flatMap(f=>UnderlyingInstrRegistryField.decode(f)),
        myFields.get(UnderlyingCountryOfIssueField.TagId).flatMap(f=>UnderlyingCountryOfIssueField.decode(f)),
        myFields.get(UnderlyingStateOrProvinceOfIssueField.TagId).flatMap(f=>UnderlyingStateOrProvinceOfIssueField.decode(f)),
        myFields.get(UnderlyingLocaleOfIssueField.TagId).flatMap(f=>UnderlyingLocaleOfIssueField.decode(f)),
        myFields.get(UnderlyingRedemptionDateField.TagId).flatMap(f=>UnderlyingRedemptionDateField.decode(f)),
        myFields.get(UnderlyingStrikePriceField.TagId).flatMap(f=>UnderlyingStrikePriceField.decode(f)),
        myFields.get(UnderlyingStrikeCurrencyField.TagId).flatMap(f=>UnderlyingStrikeCurrencyField.decode(f)),
        myFields.get(UnderlyingOptAttributeField.TagId).flatMap(f=>UnderlyingOptAttributeField.decode(f)),
        myFields.get(UnderlyingContractMultiplierField.TagId).flatMap(f=>UnderlyingContractMultiplierField.decode(f)),
        myFields.get(UnderlyingCouponRateField.TagId).flatMap(f=>UnderlyingCouponRateField.decode(f)),
        myFields.get(UnderlyingSecurityExchangeField.TagId).flatMap(f=>UnderlyingSecurityExchangeField.decode(f)),
        myFields.get(UnderlyingIssuerField.TagId).flatMap(f=>UnderlyingIssuerField.decode(f)),
        myFields.get(EncodedUnderlyingIssuerLenField.TagId).flatMap(f=>EncodedUnderlyingIssuerLenField.decode(f)),
        myFields.get(EncodedUnderlyingIssuerField.TagId).flatMap(f=>EncodedUnderlyingIssuerField.decode(f)),
        myFields.get(UnderlyingSecurityDescField.TagId).flatMap(f=>UnderlyingSecurityDescField.decode(f)),
        myFields.get(EncodedUnderlyingSecurityDescLenField.TagId).flatMap(f=>EncodedUnderlyingSecurityDescLenField.decode(f)),
        myFields.get(EncodedUnderlyingSecurityDescField.TagId).flatMap(f=>EncodedUnderlyingSecurityDescField.decode(f)),
        myFields.get(UnderlyingCPProgramField.TagId).flatMap(f=>UnderlyingCPProgramField.decode(f)),
        myFields.get(UnderlyingCPRegTypeField.TagId).flatMap(f=>UnderlyingCPRegTypeField.decode(f)),
        myFields.get(UnderlyingCurrencyField.TagId).flatMap(f=>UnderlyingCurrencyField.decode(f)),
        myFields.get(UnderlyingQtyField.TagId).flatMap(f=>UnderlyingQtyField.decode(f)),
        myFields.get(UnderlyingPxField.TagId).flatMap(f=>UnderlyingPxField.decode(f)),
        myFields.get(UnderlyingDirtyPriceField.TagId).flatMap(f=>UnderlyingDirtyPriceField.decode(f)),
        myFields.get(UnderlyingEndPriceField.TagId).flatMap(f=>UnderlyingEndPriceField.decode(f)),
        myFields.get(UnderlyingStartValueField.TagId).flatMap(f=>UnderlyingStartValueField.decode(f)),
        myFields.get(UnderlyingCurrentValueField.TagId).flatMap(f=>UnderlyingCurrentValueField.decode(f)),
        myFields.get(UnderlyingEndValueField.TagId).flatMap(f=>UnderlyingEndValueField.decode(f)),
        UnderlyingStipulationsComponent.decode(flds, startPos)))
    } else None
  }

    
}
     