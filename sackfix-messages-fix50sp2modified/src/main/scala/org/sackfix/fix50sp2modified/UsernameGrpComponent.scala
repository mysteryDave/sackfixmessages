package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class UsernameGrpComponent(noUsernamesField:Option[NoUsernamesField]=None,
                                usernamesGroups: Option[List[UsernamesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUsernamesField.map(_.value).getOrElse(0) != usernamesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUsernamesField.TagId,noUsernamesField.map(_.value).getOrElse(0), usernamesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noUsernamesField.foreach(fmt(b,_))
    usernamesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object UsernameGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    UsernamesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoUsernamesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    UsernamesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    UsernamesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUsernamesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = UsernamesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[UsernameGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(UsernameGrpComponent(myFields.get(NoUsernamesField.TagId).flatMap(f=>NoUsernamesField.decode(f)),
        if (nextTagPosLookup.contains(NoUsernamesField.TagId)) UsernamesGroup.decode(flds, nextTagPosLookup(NoUsernamesField.TagId)) else None))
    } else None
  }

    
}
     