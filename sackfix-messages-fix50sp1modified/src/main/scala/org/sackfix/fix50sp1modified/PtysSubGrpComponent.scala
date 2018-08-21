package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class PtysSubGrpComponent(noPartySubIDsField:Option[NoPartySubIDsField]=None,
                               partySubIDsGroups: Option[List[PartySubIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noPartySubIDsField.map(_.value).getOrElse(0) != partySubIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoPartySubIDsField.TagId,noPartySubIDsField.map(_.value).getOrElse(0), partySubIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noPartySubIDsField.foreach(fmt(b,_))
    partySubIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object PtysSubGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartySubIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoPartySubIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartySubIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartySubIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoPartySubIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = PartySubIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[PtysSubGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(PtysSubGrpComponent(myFields.get(NoPartySubIDsField.TagId).flatMap(f=>NoPartySubIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoPartySubIDsField.TagId)) PartySubIDsGroup.decode(flds, nextTagPosLookup(NoPartySubIDsField.TagId)) else None))
    } else None
  }

    
}
     