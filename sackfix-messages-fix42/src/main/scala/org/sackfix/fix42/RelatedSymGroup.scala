package org.sackfix.fix42

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX42.xml
  */
case class RelatedSymGroup(underlyingSymbolField:Option[UnderlyingSymbolField]=None,
                           underlyingSymbolSfxField:Option[UnderlyingSymbolSfxField]=None,
                           underlyingSecurityIDField:Option[UnderlyingSecurityIDField]=None,
                           underlyingIDSourceField:Option[UnderlyingIDSourceField]=None,
                           underlyingSecurityTypeField:Option[UnderlyingSecurityTypeField]=None,
                           underlyingMaturityMonthYearField:Option[UnderlyingMaturityMonthYearField]=None,
                           underlyingMaturityDayField:Option[UnderlyingMaturityDayField]=None,
                           underlyingPutOrCallField:Option[UnderlyingPutOrCallField]=None,
                           underlyingStrikePriceField:Option[UnderlyingStrikePriceField]=None,
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
                           ratioQtyField:Option[RatioQtyField]=None,
                           sideField:Option[SideField]=None,
                           underlyingCurrencyField:Option[UnderlyingCurrencyField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    underlyingSymbolField.foreach(fmt(b,_))
    underlyingSymbolSfxField.foreach(fmt(b,_))
    underlyingSecurityIDField.foreach(fmt(b,_))
    underlyingIDSourceField.foreach(fmt(b,_))
    underlyingSecurityTypeField.foreach(fmt(b,_))
    underlyingMaturityMonthYearField.foreach(fmt(b,_))
    underlyingMaturityDayField.foreach(fmt(b,_))
    underlyingPutOrCallField.foreach(fmt(b,_))
    underlyingStrikePriceField.foreach(fmt(b,_))
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
    ratioQtyField.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    underlyingCurrencyField.foreach(fmt(b,_))
    b
  }

}
     
object RelatedSymGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    UnderlyingSymbolField.TagId, UnderlyingSymbolSfxField.TagId, UnderlyingSecurityIDField.TagId, UnderlyingIDSourceField.TagId, UnderlyingSecurityTypeField.TagId, 
    UnderlyingMaturityMonthYearField.TagId, UnderlyingMaturityDayField.TagId, UnderlyingPutOrCallField.TagId, UnderlyingStrikePriceField.TagId, UnderlyingOptAttributeField.TagId, 
    UnderlyingContractMultiplierField.TagId, UnderlyingCouponRateField.TagId, UnderlyingSecurityExchangeField.TagId, UnderlyingIssuerField.TagId, EncodedUnderlyingIssuerLenField.TagId, 
    EncodedUnderlyingIssuerField.TagId, UnderlyingSecurityDescField.TagId, EncodedUnderlyingSecurityDescLenField.TagId, EncodedUnderlyingSecurityDescField.TagId, RatioQtyField.TagId, 
    SideField.TagId, UnderlyingCurrencyField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==UnderlyingSymbolField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[RelatedSymGroup]=ArrayBuffer.empty[RelatedSymGroup]):Option[List[RelatedSymGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[RelatedSymGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[RelatedSymGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(RelatedSymGroup(myFields.get(UnderlyingSymbolField.TagId).flatMap(f=>UnderlyingSymbolField.decode(f)),
          myFields.get(UnderlyingSymbolSfxField.TagId).flatMap(f=>UnderlyingSymbolSfxField.decode(f)),
          myFields.get(UnderlyingSecurityIDField.TagId).flatMap(f=>UnderlyingSecurityIDField.decode(f)),
          myFields.get(UnderlyingIDSourceField.TagId).flatMap(f=>UnderlyingIDSourceField.decode(f)),
          myFields.get(UnderlyingSecurityTypeField.TagId).flatMap(f=>UnderlyingSecurityTypeField.decode(f)),
          myFields.get(UnderlyingMaturityMonthYearField.TagId).flatMap(f=>UnderlyingMaturityMonthYearField.decode(f)),
          myFields.get(UnderlyingMaturityDayField.TagId).flatMap(f=>UnderlyingMaturityDayField.decode(f)),
          myFields.get(UnderlyingPutOrCallField.TagId).flatMap(f=>UnderlyingPutOrCallField.decode(f)),
          myFields.get(UnderlyingStrikePriceField.TagId).flatMap(f=>UnderlyingStrikePriceField.decode(f)),
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
          myFields.get(RatioQtyField.TagId).flatMap(f=>RatioQtyField.decode(f)),
          myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
          myFields.get(UnderlyingCurrencyField.TagId).flatMap(f=>UnderlyingCurrencyField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     