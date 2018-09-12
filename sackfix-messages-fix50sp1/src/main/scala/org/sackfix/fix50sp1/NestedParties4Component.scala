package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class NestedParties4Component(noNested4PartyIDsField:Option[NoNested4PartyIDsField]=None,
                                   nested4PartyIDsGroups: Option[List[Nested4PartyIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noNested4PartyIDsField.map(_.value).getOrElse(0) != nested4PartyIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoNested4PartyIDsField.TagId,noNested4PartyIDsField.map(_.value).getOrElse(0), nested4PartyIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noNested4PartyIDsField.foreach(fmt(b,_))
    nested4PartyIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object NestedParties4Component extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    Nested4PartyIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoNested4PartyIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    Nested4PartyIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    Nested4PartyIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoNested4PartyIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = Nested4PartyIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[NestedParties4Component] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(NestedParties4Component(myFields.get(NoNested4PartyIDsField.TagId).flatMap(f=>NoNested4PartyIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoNested4PartyIDsField.TagId)) Nested4PartyIDsGroup.decode(flds, nextTagPosLookup(NoNested4PartyIDsField.TagId)) else None))
    } else None
  }

    
}
     