package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class RegistDtlsGroup(registDtlsField:Option[RegistDtlsField]=None,
                           registEmailField:Option[RegistEmailField]=None,
                           mailingDtlsField:Option[MailingDtlsField]=None,
                           mailingInstField:Option[MailingInstField]=None,
                           nestedPartiesComponent:Option[NestedPartiesComponent]=None,
                           ownerTypeField:Option[OwnerTypeField]=None,
                           dateOfBirthField:Option[DateOfBirthField]=None,
                           investorCountryOfResidenceField:Option[InvestorCountryOfResidenceField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    registDtlsField.foreach(fmt(b,_))
    registEmailField.foreach(fmt(b,_))
    mailingDtlsField.foreach(fmt(b,_))
    mailingInstField.foreach(fmt(b,_))
    nestedPartiesComponent.foreach(fmt(b,_))
    ownerTypeField.foreach(fmt(b,_))
    dateOfBirthField.foreach(fmt(b,_))
    investorCountryOfResidenceField.foreach(fmt(b,_))
    b
  }

}
     
object RegistDtlsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NestedPartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    RegistDtlsField.TagId, RegistEmailField.TagId, MailingDtlsField.TagId, MailingInstField.TagId, OwnerTypeField.TagId, 
    DateOfBirthField.TagId, InvestorCountryOfResidenceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NestedPartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NestedPartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==RegistDtlsField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[RegistDtlsGroup]=ArrayBuffer.empty[RegistDtlsGroup]):Option[List[RegistDtlsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[RegistDtlsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[RegistDtlsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(RegistDtlsGroup(myFields.get(RegistDtlsField.TagId).flatMap(f=>RegistDtlsField.decode(f)),
          myFields.get(RegistEmailField.TagId).flatMap(f=>RegistEmailField.decode(f)),
          myFields.get(MailingDtlsField.TagId).flatMap(f=>MailingDtlsField.decode(f)),
          myFields.get(MailingInstField.TagId).flatMap(f=>MailingInstField.decode(f)),
          NestedPartiesComponent.decode(flds, startPos),
          myFields.get(OwnerTypeField.TagId).flatMap(f=>OwnerTypeField.decode(f)),
          myFields.get(DateOfBirthField.TagId).flatMap(f=>DateOfBirthField.decode(f)),
          myFields.get(InvestorCountryOfResidenceField.TagId).flatMap(f=>InvestorCountryOfResidenceField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     