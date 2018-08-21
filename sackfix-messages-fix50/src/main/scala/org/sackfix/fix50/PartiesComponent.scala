package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class PartiesComponent(noPartyIDsField:Option[NoPartyIDsField]=None,
                            partyIDsGroups: Option[List[PartyIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noPartyIDsField.map(_.value).getOrElse(0) != partyIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoPartyIDsField.TagId,noPartyIDsField.map(_.value).getOrElse(0), partyIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noPartyIDsField.foreach(fmt(b,_))
    partyIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object PartiesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartyIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoPartyIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartyIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartyIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoPartyIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = PartyIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[PartiesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(PartiesComponent(myFields.get(NoPartyIDsField.TagId).flatMap(f=>NoPartyIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoPartyIDsField.TagId)) PartyIDsGroup.decode(flds, nextTagPosLookup(NoPartyIDsField.TagId)) else None))
    } else None
  }

    
}
     