package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class RegistrationInstructionsMessage(registIDField:RegistIDField,
                                           registTransTypeField:RegistTransTypeField,
                                           registRefIDField:RegistRefIDField,
                                           clOrdIDField:Option[ClOrdIDField]=None,
                                           partiesComponent:Option[PartiesComponent]=None,
                                           accountField:Option[AccountField]=None,
                                           acctIDSourceField:Option[AcctIDSourceField]=None,
                                           registAcctTypeField:Option[RegistAcctTypeField]=None,
                                           taxAdvantageTypeField:Option[TaxAdvantageTypeField]=None,
                                           ownershipTypeField:Option[OwnershipTypeField]=None,
                                           noRegistDtlsField:Option[NoRegistDtlsField]=None,
                                           registDtlsGroups: Option[List[RegistDtlsGroup]]=None,
                                           noDistribInstsField:Option[NoDistribInstsField]=None,
                                           distribInstsGroups: Option[List[DistribInstsGroup]]=None) extends SfFixMessageBody("o")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noRegistDtlsField.map(_.value).getOrElse(0) != registDtlsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoRegistDtlsField.TagId,noRegistDtlsField.map(_.value).getOrElse(0), registDtlsGroups.map(_.size).getOrElse(0))
  if (noDistribInstsField.map(_.value).getOrElse(0) != distribInstsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoDistribInstsField.TagId,noDistribInstsField.map(_.value).getOrElse(0), distribInstsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,registIDField)
    fmt(b,registTransTypeField)
    fmt(b,registRefIDField)
    clOrdIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    registAcctTypeField.foreach(fmt(b,_))
    taxAdvantageTypeField.foreach(fmt(b,_))
    ownershipTypeField.foreach(fmt(b,_))
    noRegistDtlsField.foreach(fmt(b,_))
    registDtlsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noDistribInstsField.foreach(fmt(b,_))
    distribInstsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object RegistrationInstructionsMessage extends SfFixMessageDecoder {
  val MsgType="o"
  val MsgName="RegistrationInstructions"
             
  override val MandatoryFields = HashSet[Int](
    RegistIDField.TagId, RegistTransTypeField.TagId, RegistRefIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || RegistDtlsGroup.isMandatoryField(tagId) || DistribInstsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ClOrdIDField.TagId, AccountField.TagId, AcctIDSourceField.TagId, RegistAcctTypeField.TagId, TaxAdvantageTypeField.TagId, 
    OwnershipTypeField.TagId, NoRegistDtlsField.TagId, NoDistribInstsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || RegistDtlsGroup.isOptionalField(tagId) || DistribInstsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || RegistDtlsGroup.isFieldOf(tagId) || DistribInstsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoRegistDtlsField.TagId, NoDistribInstsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==RegistIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(RegistrationInstructionsMessage(RegistIDField.decode(myFields.get(RegistIDField.TagId)).get,
        RegistTransTypeField.decode(myFields.get(RegistTransTypeField.TagId)).get,
        RegistRefIDField.decode(myFields.get(RegistRefIDField.TagId)).get,
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(RegistAcctTypeField.TagId).flatMap(f=>RegistAcctTypeField.decode(f)),
        myFields.get(TaxAdvantageTypeField.TagId).flatMap(f=>TaxAdvantageTypeField.decode(f)),
        myFields.get(OwnershipTypeField.TagId).flatMap(f=>OwnershipTypeField.decode(f)),
        myFields.get(NoRegistDtlsField.TagId).flatMap(f=>NoRegistDtlsField.decode(f)),
        if (nextTagPosLookup.contains(NoRegistDtlsField.TagId)) RegistDtlsGroup.decode(flds, nextTagPosLookup(NoRegistDtlsField.TagId)) else None,
        myFields.get(NoDistribInstsField.TagId).flatMap(f=>NoDistribInstsField.decode(f)),
        if (nextTagPosLookup.contains(NoDistribInstsField.TagId)) DistribInstsGroup.decode(flds, nextTagPosLookup(NoDistribInstsField.TagId)) else None))
    } else None
  }

    
}
     